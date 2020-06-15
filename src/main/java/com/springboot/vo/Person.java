package com.springboot.vo;


import com.springboot.annotation.IdCard;
import com.springboot.valid.Create;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;
import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
public class Person  {


    @NotNull(message="年龄不能为空",groups =Create.class)
    @Range(min = 1,max = 100,message = "年龄必须是100以内",groups = Create.class)
    private int age;
    @NotBlank(message = "姓名必须填",groups = Create.class)
    @Length(min = 2,message = "姓名不少于两个字符",groups = Create.class)
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9\\*]*$", message = "用户昵称限制：最多20字符，包含文字、字母和数字")
    private String lastName;
    @AssertFalse(message = "success必须填写false",groups = Create.class)
    private  boolean sucess;
    private Map<String,String> map ;
    @Valid
    private List<Dog> list;
    //@Valid
    private Dog dog;

    @IdCard(message = "身份证信息不合法",groups = Create.class)
    private  String idCard;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Email(message = "邮箱格式不正确",groups = Create.class)
    private String email;

    @Pattern(regexp = "^[1][345678][0-9]{9}$",message = "手机号格式不正确",groups = Create.class)
    private String phoneNum;

    @Past(message = "时间不能是将来时间",groups = Create.class)
    private Date createTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", lastName='" + lastName + '\'' +
                ", sucess=" + sucess +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<Dog> getList() {
        return list;
    }

    public void setList(List<Dog> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
