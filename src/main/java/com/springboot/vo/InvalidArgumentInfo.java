package com.springboot.vo;

        import lombok.Data;

/**
 * @author zhaolei
 * @date 2020-06-02 16:53
 */

@Data
public class InvalidArgumentInfo {

    private String field;
    private Object rejectedValue;
    private String defaultMessage;

}
