package com.gottaboy.iching.mybatis.rpc.core;

import lombok.Data;

/**
 * @author iching
 * @since 2019/8/20
 */
@Data
public class Response {
    private String result;
    private String identify;
    private String requestId;

    public static Response create(String result, String identify, String requestId) {
        Response response = new Response();
        response.setResult(result);
        response.setIdentify(identify);
        response.setRequestId(requestId);
        return response;
    }
}
