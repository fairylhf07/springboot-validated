package com.springboot.controller;


import com.springboot.utils.ValidationUtils;
import com.springboot.valid.Create;
import com.springboot.vo.Person;
import com.springboot.vo.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/validated")
public class ValidatedController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/validPerson")
    @ResponseBody
    public RespData  testValidated( /*@Validated(Create.class) */Person person) throws BindException {
        logger.info("-------------前端请求参数person:{}",person);

            ValidationUtils.validate(person,Create.class);

        RespData respData = new RespData(person);
        logger.info("-------------返回给前端的信息:{}",respData);
         return    respData ;
    }
}
