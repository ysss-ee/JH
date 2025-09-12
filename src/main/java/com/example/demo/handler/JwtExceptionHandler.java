package com.example.demo.handler;

import com.example.demo.dto.Result;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Order(20)
public class JwtExceptionHandler {

    @ExceptionHandler({ExpiredJwtException.class})
    @ResponseBody
    public Result<Object> handleExpiredJwtException(ExpiredJwtException e) {
        return Result.error(401, "JWT token has expired");
    }

    @ExceptionHandler({JwtException.class, AuthenticationException.class})
    @ResponseBody
    public Result<Object> handleJwtException(Exception e) {
        return Result.error(401, "Invalid JWT token");
    }
}

