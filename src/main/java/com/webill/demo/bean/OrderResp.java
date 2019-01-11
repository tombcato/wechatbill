package com.webill.demo.bean;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderResp {
    /**
     * ret_code : 0
     * ret_msg : OK
     * statistic : [{"year":2018,"month":12,"receive_fee":863,"pay_fee":202109,"fee_unit":"￥","userroll_count":59}]
     * total : 20
     * last_bill_id : 33bd115c20a107007f977500
     * last_bill_type : 1
     * last_trans_id : 4200000230201812132240256412
     * last_create_time : 1544666419
     * is_over : false
     */

    private int ret_code;
    private String ret_msg;
    private int total;
    private String last_bill_id;
    private int last_bill_type;
    private String last_trans_id;
    private int last_create_time;
    private boolean is_over;
    private List<Orders> record;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getLast_bill_id() {
        return last_bill_id;
    }

    public void setLast_bill_id(String last_bill_id) {
        this.last_bill_id = last_bill_id;
    }

    public int getLast_bill_type() {
        return last_bill_type;
    }

    public void setLast_bill_type(int last_bill_type) {
        this.last_bill_type = last_bill_type;
    }

    public String getLast_trans_id() {
        return last_trans_id;
    }

    public void setLast_trans_id(String last_trans_id) {
        this.last_trans_id = last_trans_id;
    }

    public int getLast_create_time() {
        return last_create_time;
    }

    public void setLast_create_time(int last_create_time) {
        this.last_create_time = last_create_time;
    }

    public boolean isIs_over() {
        return is_over;
    }

    public void setIs_over(boolean is_over) {
        this.is_over = is_over;
    }

    public List<Orders> getRecord() {
        return record;
    }

    public void setRecord(List<Orders> record) {
        this.record = record;
    }
}
