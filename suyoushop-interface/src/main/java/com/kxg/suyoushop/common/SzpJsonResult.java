package com.kxg.suyoushop.common;

public class SzpJsonResult<T> {
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    private String ok; // 不使用


    public static SzpJsonResult build(Integer status, String msg, Object data) {
        return new SzpJsonResult(status, msg, data);
    }

    public static SzpJsonResult ok(Object data) {
        return new SzpJsonResult(data);
    }

    public static SzpJsonResult ok() {
        return new SzpJsonResult(null);
    }

    public static SzpJsonResult errorMsg(String msg) {
        return new SzpJsonResult(500, msg, null);
    }

    public static SzpJsonResult errorMap(Object data) {
        return new SzpJsonResult(501, "error", data);
    }

    public static SzpJsonResult errorTokenMsg(String msg) {
        return new SzpJsonResult(502, msg, null);
    }

    public static SzpJsonResult errorException(String msg) {
        return new SzpJsonResult(555, msg, null);
    }

    public SzpJsonResult() {

    }

    public SzpJsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public SzpJsonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
