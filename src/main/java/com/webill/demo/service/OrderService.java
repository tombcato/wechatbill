package com.webill.demo.service;

import com.google.gson.Gson;
import com.webill.demo.DemoApplication;
import com.webill.demo.bean.Orders;
import com.webill.demo.bean.OrderResp;
import com.webill.demo.repo.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderService {
    public static final int PAGE_SIZE = 50;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Autowired
    OrderDao orderDao;

    @Autowired
    RestTemplate restTemplate;

    public boolean checkWechatId(String wechatId) {
        return true;
    }

    //    @Async("taskExecutor")
    public void createGetBillTask(String wechatId, String exportkey, String userroll_encryption, String userroll_pass_ticket) {
        DemoApplication.logger.warn("创建任务：" + exportkey);
        long start = System.currentTimeMillis();

        Map<String, String> headMaps = new LinkedHashMap<>();
        headMaps.put("Accept", "*/*");
        headMaps.put("Accept-Encoding", "gzip, deflate");
        headMaps.put("Accept-Language", "zh-CN,en-US;q=0.8");
        headMaps.put("Connection", "keep-alive");
        headMaps.put("Cookie", "userroll_encryption=" + userroll_encryption + "; userroll_pass_ticket=" + userroll_pass_ticket);
        headMaps.put("Host", "wx.tenpay.com");
        headMaps.put("Q-Auth", "复制 Q-Auth");
        headMaps.put("Q-GUID", "复制 Q-GUID");
        headMaps.put("Q-UA2", "复制 Q-UA2");
        headMaps.put("Referer", "https://wx.tenpay.com/?classify_type=0");
        headMaps.put("User-Agent", "Mozilla/5.0 (Linux; Android 8.0; MIX 2 Build/OPR1.170623.027; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044408 Mobile Safari/537.36 MMWEBID/4508 MicroMessenger/7.0.1380(0x27000038) Process/tools NetType/WIFI Language/zh_CN");
        headMaps.put("X-DevTools-Emulate-Network-Conditions-Client-Id", "复制 Id");
        headMaps.put("X-Requested-With", "com.tencent.mm");
        HttpHeaders headers = new HttpHeaders();
        headers.clear();
        headers.setAll(headMaps);
        headers.setExpires(0);
        headers.setCacheControl("private, no-store, max-age=0");
        HttpEntity entity = new HttpEntity(headers);

        OrderResp lastResp = null;
        while (true) {
            String url = "https://wx.tenpay.com/userroll/userrolllist?classify_type=0&count=" + PAGE_SIZE + "&sort_type=1";
            Map<String, Object> queryMaps = new LinkedHashMap<>();
            if (lastResp != null) {
                //小于2017-12-31 跳出
                if (lastResp.getLast_create_time() < 1514736000) {
                    break;
                }

                url += "&exportkey={exportkey}&last_bill_id={last_bill_id}&last_bill_type={last_bill_type}&last_create_time={last_create_time}&last_trans_id={last_trans_id}&start_time={start_time}";
                queryMaps.put("exportkey", exportkey);
                queryMaps.put("last_bill_id", lastResp.getLast_bill_id());
                queryMaps.put("last_bill_type", lastResp.getLast_bill_type());
                queryMaps.put("last_create_time", lastResp.getLast_create_time());
                queryMaps.put("last_trans_id", lastResp.getLast_trans_id());
                queryMaps.put("start_time", lastResp.getLast_create_time());
            }
            try {
                URI uri = restTemplate.getUriTemplateHandler().expand(url, queryMaps);

                ResponseEntity<OrderResp> resp = restTemplate.exchange(uri, HttpMethod.GET, entity, OrderResp.class);
                DemoApplication.logger.warn("任务信息：" + uri.toString() + "\nheader:" + resp.getHeaders().toString());
                if (!resp.getStatusCode().is2xxSuccessful()) {
                    DemoApplication.logger.warn("任务请求网络失败：" + resp.toString());
                    break;
                }
                OrderResp body = resp.getBody();
                if (body == null || body.getRet_code() != 0 || body.getRecord() == null || body.getRecord().isEmpty()) {
                    DemoApplication.logger.warn("任务请求失败：" + url);
                    break;
                }
                List<Orders> records = body.getRecord();
                for (Orders order : records) {
                    order.setWechat_id(wechatId);
                }

                //保存数据库
                orderDao.saveAll(records);
                orderDao.flush();

                lastResp = body;
                long timestamp = lastResp.getLast_create_time();

                String format = sdf.format(new Date(timestamp * 1000));
                DemoApplication.logger.warn("任务进行中：" + exportkey + ":已导入至：" + format);

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        long end = System.currentTimeMillis();
        DemoApplication.logger.warn("完成任务" + exportkey + "，耗时：" + (end - start) + "毫秒");
    }


}