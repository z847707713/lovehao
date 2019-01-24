package cn.lovehao.dto;

public class ResponseMsg<T> {

    public static final int ERROR_CODE = 0;
    public static final int SUCCESS_CODE = 1;
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    private T data;
    private Integer code;
    private String msg;

    public ResponseMsg() {
    }

    public ResponseMsg(T data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
