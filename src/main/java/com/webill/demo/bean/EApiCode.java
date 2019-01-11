package com.webill.demo.bean;

import org.springframework.stereotype.Component;

public enum  EApiCode {
    ERROR(-1),
    SUCCESS(0);

    private int code;
    EApiCode(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}
