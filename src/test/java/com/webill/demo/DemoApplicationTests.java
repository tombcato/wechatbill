package com.webill.demo;

import com.webill.demo.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoApplicationTests {

    @Autowired
    OrderService mOrderService;

    @Test
    public void contextLoads() {
    }


    @Test
    public void createTask(){
        mOrderService.createGetBillTask("随便填",
                "复制 exportkey",
                "复制 userroll_encryption",
                "复制 userroll_pass_ticket");
    }
}

