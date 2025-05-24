package com.draic.homework.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {


  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Result> handleValidationException(MethodArgumentNotValidException ex) {
    // 获取第一个验证错误消息
    Result<Object> result =
            Result.builder().code("50000").status("fail").message(ex.getFieldError().getDefaultMessage()).build();

    return  new ResponseEntity(result, HttpStatus.OK);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Result> handleException(Exception e) {

    Result<Object> result =
        Result.builder().code("50000").status("fail").message(e.getMessage()).build();

    return new ResponseEntity(result, HttpStatus.OK);
  }
}
