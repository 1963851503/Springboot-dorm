package com.jsjx.dorm.config.log;

import com.jsjx.dorm.config.log.enums.ErrorStateCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 业务入参逻辑检查错误
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UseCheckException extends RuntimeException {

    /**
     * 状态码
     */
    private ErrorStateCode useState;

    /**
     * 错误信息（多语言处理）
     */
    private String message;

    /**
     * 辅助名称
     */
    private String helperName;
}
