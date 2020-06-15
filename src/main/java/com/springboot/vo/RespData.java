package com.springboot.vo;

import com.springboot.constant.RespInfoEnum;

public class RespData  {

    String respCode;
    String respDesc;
    Object data;

    public RespData() {
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RespData(Object data) {
        this.respCode = RespInfoEnum.SUCCESS.getRespCode();
        this.respDesc = RespInfoEnum.SUCCESS.getRespDesc();
        this.data = data;
    }
    public RespData(String respCode, String respDesc) {
        this.respCode = respCode;
        this.respDesc = respDesc;
    }
    public RespData(String respCode, String respDesc, Object data) {
        this.respCode = respCode;
        this.respDesc = respDesc;
        this.data = data;
    }

    @Override
    public String toString() {
        return "RespData{" +
                "respCode='" + respCode + '\'' +
                ", respDesc='" + respDesc + '\'' +
                ", data=" + data +
                '}';
    }
}
