# wechatbill
统计2018微信年度账单  
实现思路地址为：https://juejin.im/post/5c383aa66fb9a049e412e9f3

- IDE IntelliJ IDEA
- 数据库 Mysql 8.0
- 开发框架 Spring Boot 2.2
## 1、先执行db目录下的wechat.sql脚本。  
mysql执行方法：
>在终端中输入“mysql -u root -p   
输入密码：  
进入Mysql数据库  
输入“source 文件路径*.sql;  
执行*.sql文件，数据库及表即建立完成。

## 2、修改application.properties中的mysql连接参数 username password

## 3、修改请求微信接口的相关数据填充请求中的数据，全局搜索"复制"替换参数,参数获取请看：https://juejin.im/post/5c383aa66fb9a049e412e9f3
    
