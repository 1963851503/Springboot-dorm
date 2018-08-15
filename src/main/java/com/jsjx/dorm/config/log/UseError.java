package com.jsjx.dorm.config.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UseError {

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 错误信息（多语言处理）
     */
    private String message;

    /**
     * 辅助名称
     */
    private String helperName;

    /**
     *
     */
    private Date timestamp= new Date();

    /**
     *
     */
    private String error;

    /**
     *
     */
    private String path;
}
