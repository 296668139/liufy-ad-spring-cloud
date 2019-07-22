package com.liufy.ad.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = -1889582130327850227L;

    private Integer code;
    private String message;
    private T data;

    private CommonResponse(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Boolean isSuccess(){
        return ResponseCode.SUCCESS.getCode().equals(this.code);
    }

    public static <T>CommonResponse<T> createSuccess(T data){
        return new CommonResponse<>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc(),data);
    }

    public static <T>CommonResponse<T> createSuccess(String message,T data){
        return new CommonResponse<>(ResponseCode.SUCCESS.getCode(),message,data);
    }
    public static CommonResponse createSuccessByMessage(String message){
        return new CommonResponse(ResponseCode.SUCCESS.getCode(),message);
    }

    public static <T>CommonResponse<T> createError(T data){
        return new CommonResponse<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc(),data);
    }

    public static <T>CommonResponse<T> createError(String message,T data){
        return new CommonResponse<>(ResponseCode.ERROR.getCode(),message,data);
    }
    public static CommonResponse createErrorByMessage(String message){
        return new CommonResponse(ResponseCode.ERROR.getCode(),message);
    }


}
