package com.jsjx.dorm.config.advicehandler;


import lombok.Data;

import java.io.Serializable;

/**
 * 全局异常处理：实体 ApiResult
 * api所有结构返回实体，由jsonobject改成该类
 * 最终呈现还是json方式
 */
@Data
public class ApiResult implements Serializable
{
    //禁止new创建对象
    private ApiResult() {}

    /**
     * 统一创建ApiResultBean对象
     * 方便后期扩展
     * @return
     */
    public static ApiResult newInstance(){
        return new ApiResult();
    }

    //消息提示
    private String msg;
    //状态信息
    private boolean flag = true;
    //返回结构
    private Object result;
    //查询出的结构总数
    private int rows;
    //需要跳转的路径
    private String jumpUrl;
    //接口相应时间毫秒单位
    private long time;
}
