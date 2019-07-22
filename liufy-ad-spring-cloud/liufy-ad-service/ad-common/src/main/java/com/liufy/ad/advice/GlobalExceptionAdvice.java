package com.liufy.ad.advice;

import com.liufy.ad.exception.ADException;
import com.liufy.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = ADException.class)
    public CommonResponse<String> adException(HttpServletRequest request, ADException e){
        return CommonResponse.createError("捕捉到异常",e.getMessage());
    }
}
