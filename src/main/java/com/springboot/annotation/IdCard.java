package com.springboot.annotation;

import com.springboot.valid.IdCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author zhaolei
 * @date 2020-06-01 17:45
 */


@Target(value = {ElementType.FIELD,ElementType.PARAMETER})
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IdCardValidator.class})
public @interface IdCard {

    String message() default "身份证号码不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
