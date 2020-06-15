package com.springboot.constant;

public enum RespInfoEnum {

    ERROR("999","系统错误"),
    PARAM_ERROR("199","参数错误"),
    SUCCESS("000","成功");
    private String respCode;
    private  String respDesc;


    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    RespInfoEnum(String respCode, String respDesc) {
        this.respCode = respCode;
        this.respDesc = respDesc;
    }
}
