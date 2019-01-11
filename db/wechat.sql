create database wechatbill;

use wechatbill;

create table order_type
(
  type     int          null,
  type_str varchar(100) null
);

INSERT INTO wechatbill.order_type (type, type_str) VALUES (0, '全部');
INSERT INTO wechatbill.order_type (type, type_str) VALUES (2, '红包收款');
INSERT INTO wechatbill.order_type (type, type_str) VALUES (1, '转账');
INSERT INTO wechatbill.order_type (type, type_str) VALUES (5, '群收款');
INSERT INTO wechatbill.order_type (type, type_str) VALUES (3, '二维码收付款');
INSERT INTO wechatbill.order_type (type, type_str) VALUES (6, '商户消费');
INSERT INTO wechatbill.order_type (type, type_str) VALUES (4, '充值提现');
INSERT INTO wechatbill.order_type (type, type_str) VALUES (9, '信用卡还款');
INSERT INTO wechatbill.order_type (type, type_str) VALUES (10, '有退款');
INSERT INTO wechatbill.order_type (type, type_str) VALUES (31, '红包退款');
INSERT INTO wechatbill.order_type (type, type_str) VALUES (11, '微信支付周末摇摇乐');

create table orders
(
  id                 int auto_increment
    primary key,
  bill_id            varchar(100) null,
  trans_id           varchar(100) null,
  title              varchar(200) null,
  timestamp          mediumtext   null,
  fee                int          null,
  fee_type           varchar(20)  null,
  fee_attr           varchar(20)  null,
  current_state      varchar(100) null,
  current_state_type varchar(100) null,
  bill_type          int          null,
  icon_url           varchar(255) null,
  out_trade_no       varchar(100) null,
  total_refund_fee   int          null,
  classify_type      int          null,
  pay_bank_name      varchar(50)  null,
  remark             varchar(50)  null,
  business_data      varchar(50)  null,
  charge_fee         int          null,
  payer_remark       varchar(50)  null,
  payer_uin          mediumtext   null,
  payer_wxid         varchar(50)  null,
  is_friend          tinyint(1)   null,
  wechat_id          varchar(100) null
);