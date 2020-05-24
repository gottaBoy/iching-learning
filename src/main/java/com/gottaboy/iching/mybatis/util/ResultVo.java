package com.gottaboy.iching.mybatis.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//模型表上注解
@Data  //lombok插件的注解，自动生成get,set方法
@ApiModel(value="ResultVo",description = "http请求返回的最外层对象")
public class ResultVo<T> {

    /** 错误码. */
    @ApiModelProperty(value="返回码",name="code")
    private Integer code;

    /** 提示信息. */
    @ApiModelProperty(value="提示信息",name="msg")
    private String msg;

    /** 具体内容. */
    @ApiModelProperty(value="具体内容",name="data")
    private T data;
}