package com.tensquare_base.controller;

import com.tensquare_common.entity.Result;
import com.tensquare_common.entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e){
        return new Result(StatusCode.ERROR,false,e.getMessage());
    }
}
