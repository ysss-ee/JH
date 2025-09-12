package com.example.demo.handler;

import com.example.demo.constant.ExceptionEnum;
import com.example.demo.dto.Result;
import com.example.demo.util.HandlerUtils;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Order(1000)
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<String> handleException(Exception e) {
        HandlerUtils.logException(e);
        return Result.error(ExceptionEnum.SERVER_ERROR);
    }

}

