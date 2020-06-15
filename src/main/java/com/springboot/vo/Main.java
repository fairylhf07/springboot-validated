package com.springboot.vo;

import com.springboot.utils.ValidationUtils;
import com.springboot.valid.Create;
import com.springboot.valid.Update;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author zhaolei
 * @date 2020-06-02 11:13
 */
@Slf4j
public class Main {
    public static void main(String[] args) throws BindException {
        /*User user = new User();
        user.setAddr("上海");
        user.setBirth(new Date());
        user.setId(12);
        user.setName("guigui");
        System.out.println(user);*/
        /*log.info("-------测试lombok相关注解");
        User user1 = new User();
        user1.setId(1);
        User user = new User(1, "guizhao", "北京", new Date());
        System.out.println(user);*/

        Dog dog = new Dog("11", "纸质");
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(dog);
        Person person = new Person(1,"zhaoll",false,null,dogs,null,
                "110229199011111111","dsd@126.com","13810886402",new Date());
        ValidationUtils.validate(person,Create.class,Update.class);

    }

}
