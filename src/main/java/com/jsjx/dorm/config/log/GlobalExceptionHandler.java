package com.jsjx.dorm.config.log;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局自定义异常监控
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(UseCheckException.class)
    public ResponseEntity useCheckExcetion(UseCheckException e) {
        return new ResponseEntity(new UseError(){{
            setMessage(e.getMessage());
            setStatus(e.getUseState().getCode());
            setError(e.getLocalizedMessage());
            setHelperName(e.getHelperName());
        }}
                ,HttpStatus.SERVICE_UNAVAILABLE);
    }
}
