package com.car.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = -4305345293431646970L;

    public BaseResponse(String value){
        String[] arr = value.split(",");
        this.code = Integer.parseInt(arr[0]);
        this.msg = arr[1];
    }

    private  Integer code;       //返回码，0成功，其他 不成功
    private  String msg;        //返回信息
    private  Object data;       //json对象
}
