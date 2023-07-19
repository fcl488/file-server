package com.fcl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public static CommonResult<Object> SUCCESS() {
        return new CommonResult<>(0, "success", null);
    }

    public static CommonResult<Object> SUCCESS(Object data) {
        return new CommonResult<>(0, "success", data);
    }

    public static CommonResult<Object> FAIL() {
        return new CommonResult<>(0, "fail", null);
    }
}
