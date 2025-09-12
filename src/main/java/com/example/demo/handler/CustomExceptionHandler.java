package com.example.demo.handler;

import com.example.demo.dto.Result;
import com.example.demo.exception.ApiException;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Order(50)
public class CustomExceptionHandler {
    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public Result<Object> handleApiException(ApiException e) {
        return Result.error(e.getErrorCode(), e.getErrorMsg());
    }


}
