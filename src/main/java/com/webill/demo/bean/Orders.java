package com.webill.demo.bean;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column
  private String bill_id;
    @Column
  private String trans_id;
  @Column
  private String title;
  @Column
  private long timestamp;
  @Column
  private long fee;
    @Column
  private String fee_type;
  @Column
  private String fee_attr;
  @Column
  private String current_state;
  @Column
  private String current_state_type;
  @Column
  private long bill_type;
  @Column
  private String icon_url;
  @Column
  private String out_trade_no;
  @Column
  private long total_refund_fee;
  @Column
  private long classify_type;
  @Column
  private String pay_bank_name;
  @Column
  private String remark;
  @Column
  private String business_data;
  @Column
  private long charge_fee;
  @Column
  private String payer_remark;
  @Column
  private long payer_uin;
  @Column
  private String payer_wxid;
  @Column
  private boolean is_friend;
  @Column
  private String wechat_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(String trans_id) {
        this.trans_id = trans_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getFee_attr() {
        return fee_attr;
    }

    public void setFee_attr(String fee_attr) {
        this.fee_attr = fee_attr;
    }

    public String getCurrent_state() {
        return current_state;
    }

    public void setCurrent_state(String current_state) {
        this.current_state = current_state;
    }

    public String getCurrent_state_type() {
        return current_state_type;
    }

    public void setCurrent_state_type(String current_state_type) {
        this.current_state_type = current_state_type;
    }

    public long getBill_type() {
        return bill_type;
    }

    public void setBill_type(long bill_type) {
        this.bill_type = bill_type;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public long getTotal_refund_fee() {
        return total_refund_fee;
    }

    public void setTotal_refund_fee(long total_refund_fee) {
        this.total_refund_fee = total_refund_fee;
    }

    public long getClassify_type() {
        return classify_type;
    }

    public void setClassify_type(long classify_type) {
        this.classify_type = classify_type;
    }

    public String getPay_bank_name() {
        return pay_bank_name;
    }

    public void setPay_bank_name(String pay_bank_name) {
        this.pay_bank_name = pay_bank_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBusiness_data() {
        return business_data;
    }

    public void setBusiness_data(String business_data) {
        this.business_data = business_data;
    }

    public long getCharge_fee() {
        return charge_fee;
    }

    public void setCharge_fee(long charge_fee) {
        this.charge_fee = charge_fee;
    }

    public String getPayer_remark() {
        return payer_remark;
    }

    public void setPayer_remark(String payer_remark) {
        this.payer_remark = payer_remark;
    }

    public long getPayer_uin() {
        return payer_uin;
    }

    public void setPayer_uin(long payer_uin) {
        this.payer_uin = payer_uin;
    }

    public String getPayer_wxid() {
        return payer_wxid;
    }

    public void setPayer_wxid(String payer_wxid) {
        this.payer_wxid = payer_wxid;
    }

    public boolean isIs_friend() {
        return is_friend;
    }

    public void setIs_friend(boolean is_friend) {
        this.is_friend = is_friend;
    }

    public String getWechat_id() {
        return wechat_id;
    }

    public void setWechat_id(String wechat_id) {
        this.wechat_id = wechat_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(trans_id, orders.trans_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trans_id);
    }
}
