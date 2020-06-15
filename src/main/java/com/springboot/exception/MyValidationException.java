package com.springboot.exception;

import com.springboot.vo.InvalidArgumentInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaolei
 * @date 2020-06-02 14:49
 */
@Data
public class MyValidationException extends RuntimeException {

    private List invalidArgList ;

    public MyValidationException() {
    }

    public MyValidationException(String message) {
        super(message);
    }

    public MyValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyValidationException(Throwable cause) {
        super(cause);
    }

    public MyValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MyValidationException(ArrayList<InvalidArgumentInfo> invalidArgList) {
        this.invalidArgList = invalidArgList;
    }
}
