package com.offcn.entity;

import java.io.Serializable;

/**
 * @ClassNameResult
 * @Description TODO
 * Auther FSZZULI
 * @Date2020/4/7 20:41
 * @Version 1.0
 **/

/**
 * 全局返回结果
 * 是否成功 true false
 * 信息 message
 */
public class Result implements Serializable {

    private boolean success;

    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
