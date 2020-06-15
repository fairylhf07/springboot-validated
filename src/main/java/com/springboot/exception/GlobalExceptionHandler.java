package com.springboot.exception;

import com.springboot.constant.RespInfoEnum;
import com.springboot.vo.InvalidArgumentInfo;
import com.springboot.vo.RespData;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());



    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RespData handlerException(Exception e) {
        RespData respData = new RespData(RespInfoEnum.ERROR.getRespCode(),RespInfoEnum.ERROR.getRespDesc());
        logger.error("响应码:{},响应信息:{}", respData.getRespCode(), e.getMessage());
        return respData;
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public RespData handlerBindException(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        ArrayList<InvalidArgumentInfo> invalidArgList = new ArrayList<>();
        for (FieldError error:fieldErrors){
            InvalidArgumentInfo invalidArgumentInfo = new InvalidArgumentInfo();
            System.out.println("---在这里啦啦"+error.getField());
            invalidArgumentInfo.setField(error.getField());
            invalidArgumentInfo.setDefaultMessage(error.getDefaultMessage());
            invalidArgumentInfo.setRejectedValue(error.getRejectedValue());
            invalidArgList.add(invalidArgumentInfo);
        }
        RespData respData = new RespData(RespInfoEnum.PARAM_ERROR.getRespCode(), RespInfoEnum.PARAM_ERROR.getRespDesc(),invalidArgList);
        logger.error("响应码:{},响应信息:{}", respData.getRespCode(), respData.getRespDesc());
        return respData;
    }

    @ExceptionHandler(MyValidationException.class)
    @ResponseBody
    public  RespData  handlerMyValidationException(MyValidationException e){
        RespData respData = new RespData(RespInfoEnum.PARAM_ERROR.getRespCode(), RespInfoEnum.PARAM_ERROR.getRespDesc(),e.getInvalidArgList());
        logger.error("响应码:{},响应信息:{},详细错误：{}", respData.getRespCode(), respData.getRespDesc(),e.getInvalidArgList());
        return respData;
    }
}
