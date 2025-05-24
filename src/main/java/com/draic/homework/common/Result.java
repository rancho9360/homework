package com.draic.homework.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> {


    /**
     * 业务状态码
     */
    private String code;

    /**
     * 状态
     */
    private String status;


    private String message;

    private T data;


    public static <T> Result success(T data) {

        return Result.builder()
                .code("00000")
                .status("success")
                .message("success")
                .data(data)
                .build();


    }


    public static Result success(String message) {

        return Result.builder()
                .code("00000")
                .status("success")
                .message(message)
                .build();


    }


    public static <T> Result success(String message, T data) {

        return Result.builder()
                .code("00000")
                .status("success")
                .message(message)
                .data(data)
                .build();


    }


}
