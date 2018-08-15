package com.jsjx.dorm.config.log.enums;

import java.util.Arrays;

public enum ErrorStateCode {
    /**
     * 入参检查 1001
     */
    InCheck("InCheck",1001),
    /**
     * 出参检查 1002
     */
    OutCheck("OutCheck",1002),
    /**
     * 空指针异常 1003
     */
    NullError("NullError",1003),
    /**
     * 不唯一异常 1004
     */
    NotOnly("NotOnly",1004),
    /**
     * 未查询到符合要求的数据
     */
    NotFind("NotFind", 1005),
    /**
     * 系统异常 1005
     */
    System("System",1006);

    private Integer code;
    private String name;

    private ErrorStateCode(String name,Integer errorCode) {
        this.code = errorCode;
        this.name = name;
    }

    public static String getErrorCode(Integer code) {
        return Arrays.stream(ErrorStateCode.values()).filter(p-> p.getCode() == code).findFirst().get().getName();
    }

    public static Integer getErrorIndex(String name) {
        return Arrays.stream(ErrorStateCode.values()).filter(p-> p.getName() == name).findFirst().get().getCode();
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
