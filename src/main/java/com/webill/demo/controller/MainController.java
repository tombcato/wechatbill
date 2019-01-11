package com.webill.demo.controller;

import com.webill.demo.bean.ApiResponse;
import com.webill.demo.bean.EApiCode;
import com.webill.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wechatbills")
public class MainController {

    @Autowired
    OrderService mOrderService;

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ApiResponse createTask(@RequestParam(value = "wechatId") String wechatId,
                             @RequestParam(value = "exportkey") String exportkey,
                             @RequestParam(value = "userroll_encryption") String userroll_encryption,
                             @RequestParam(value = "userroll_pass_ticket") String userroll_pass_ticket) {
        if(mOrderService.checkWechatId(wechatId)){
            mOrderService.createGetBillTask(wechatId,exportkey, userroll_encryption, userroll_pass_ticket);
            ApiResponse<String> resp = new ApiResponse<>();
            resp.setCode(EApiCode.SUCCESS.getCode());
            resp.setMsg("创建任务成功，正在获取账单中...");
            return resp;
        }else{
            ApiResponse<String> resp = new ApiResponse<>();
            resp.setCode(EApiCode.ERROR.getCode());
            resp.setMsg("wechatId异常或冲突，创建任务失败");
            return resp;
        }
    }

}
