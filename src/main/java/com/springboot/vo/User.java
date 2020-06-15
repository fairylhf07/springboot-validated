package com.springboot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhaolei
 * @date 2020-06-02 11:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    private  Integer id;
    private  String   name;
    private  String addr;
    private Date  birth;
}
