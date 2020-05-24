package com.gottaboy.iching.mybatis.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author MinYi
 * Date：2019/5/7
 */
@Data
public class Result<T>  implements Serializable {

    private static final long serialVersionUID = -3032015199552656978L;
    private static final String SUCCESS = "0";
    private static final String ERROR = "1";
    private String code;
    private String message;
    private T data;

    public static <T> Result<T> create(String code, String message) {
        return new Result(code, message, null);
    }

    public static <T> Result<T> create(String code, String message, T data) {
        return new Result(code, message, data);
    }

    public static <T> Result<T> successData(String message, T data) {
        return create("0", message, data);
    }

    public static <T> Result<T> successMessage(String message) {
        return successData(message, null);
    }

    public static <T> Result<T> successData(T data) {
        return successData(null, data);
    }

    public static <T> Result<T> success() {
        return successMessage(null);
    }

    public static <T> Result<T> errorData(String message, T data) {
        return create("1", message, data);
    }

    public static <T> Result<T> error() {
        return errorMessage(null);
    }

    public static <T> Result<T> errorData(T data) {
        return errorData(null, data);
    }

    public static <T> Result<T> errorMessage(String message) {
        return errorData(message, null);
    }

    public static <T> Result<T> selectiveMessage(boolean success, String successMessage, String errorMessage) {
        return success ? successMessage(successMessage) : errorMessage(errorMessage);
    }

    public static <T> Result<T> selectiveMessage(boolean success, String successMessage, String errorMessage, T data) {
        return success ? successData(successMessage, data) : errorMessage(errorMessage);
    }

    public static <T> Result<T> error(Error e) {
        return e == null ? null : create("1", e.getMessage());
    }

    public static <T> Result<T> error(Exception e) {
        return e == null ? null : create("1", e.getMessage());
    }

    public Result() {
        this.setMessage("");
    }

    Result(String code, String message, T data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }
}
