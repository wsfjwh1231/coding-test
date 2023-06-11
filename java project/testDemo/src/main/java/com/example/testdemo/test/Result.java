package com.example.testdemo.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@Data
@ApiModel(description = "返回结果")
public class Result {
    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty("提示信息")
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private Object data;
}
