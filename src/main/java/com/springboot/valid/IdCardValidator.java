package com.springboot.valid;

import com.springboot.annotation.IdCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhaolei
 * @date 2020-06-01 17:50
 */
public class IdCardValidator implements ConstraintValidator<IdCard,Object> {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void initialize(IdCard constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String idCard = o.toString();
        logger.info("-------------idcard的参数是:{}",idCard);
        Pattern pattern = Pattern.compile("^[1-9]\\d{5}(18|19|20|(3\\d))\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$");
        Matcher matcher = pattern.matcher(idCard);
        if (matcher.find()){
            return true;
        }
        return false;
    }
}
