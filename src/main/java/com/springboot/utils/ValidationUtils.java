package com.springboot.utils;
import java.util.ArrayList;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.Validator;

import com.springboot.exception.MyValidationException;
import com.springboot.vo.InvalidArgumentInfo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

/**
 * 接口入参数据校验工具类.<br/>
 * 使用hibernate-validator进行校验.<br/>
 *
 * @Null   被注释的元素必须为 null
 * @NotNull    被注释的元素必须不为 null
 * @AssertTrue     被注释的元素必须为 true
 * @AssertFalse    被注释的元素必须为 false
 * @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
 * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
 * @Past   被注释的元素必须是一个过去的日期
 * @Future     被注释的元素必须是一个将来的日期
 * @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式
 * Hibernate Validator 附加的 constraint
 * @NotBlank(message =)   验证字符串非null，且长度必须大于0
 * @Email  被注释的元素必须是电子邮箱地址
 * @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内
 * @NotEmpty   被注释的字符串的必须非空
 * @Range(min=,max=,message=)  被注释的元素必须在合适的范围内
 *
 */



/**
 * @author zhaolei
 * @date 2020-06-02 14:25
 */
@Slf4j
public class ValidationUtils {
    /**
     * 使用hibernate的注解来进行验证
     */
    private static Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(false).buildValidatorFactory().getValidator();

    /**
     * 功能描述: <br>
     * 〈注解验证参数〉
     *
     * @param obj
     * @param  groupsName    注解适用的组名
     */
    public static <T> void validate(T obj,Class... groupsName) throws BindException{
        log.info("-------传入工具类中的obj内容：{}",obj);
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj,groupsName);
        log.info("-----set集合的大小：{}",constraintViolations.size());
        // 抛出检验异常
       /* if (constraintViolations.size() > 0) {
            ConstraintViolation<T> next = constraintViolations.iterator().next();
            String message = next.getMessage();
            log.info("-------message的内容是：{}",message);
            String format = String.format(message);
            log.info("----------iterator().next().getMessage()的内容是：{}",format);
            MyValidationException e = new MyValidationException(format);
            //propertyPath是校验失败的字段
            Path propertyPath = next.getPropertyPath();
            log.info("-------------------iterator().next().getPropertyPath()的内容：{}",propertyPath);
            throw e;
        }*/
        ArrayList<InvalidArgumentInfo> invalidArgList= new ArrayList<>();
        if (!CollectionUtils.isEmpty(constraintViolations)){
            for (ConstraintViolation constraintViolation:constraintViolations){
                InvalidArgumentInfo invalidArgumentInfo = new InvalidArgumentInfo();
                invalidArgumentInfo.setDefaultMessage(constraintViolation.getMessage());
                invalidArgumentInfo.setRejectedValue(constraintViolation.getInvalidValue());
                invalidArgumentInfo.setField(constraintViolation.getPropertyPath().toString());
                log.info("---------------无效参数信息：{}",invalidArgumentInfo);
                invalidArgList.add(invalidArgumentInfo);

            }
            MyValidationException e = new MyValidationException(invalidArgList);
            throw e;

        }
        log.info("------------校验通过");
    }

}
