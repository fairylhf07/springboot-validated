package com.springboot.vo;

import com.springboot.valid.Create;
import com.springboot.valid.Update;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    @NotBlank(message = "id不能为空",groups = {Create.class,Update.class})
    private String id;
    @Length(min = 4,message = "狗的名字不能少于4个字符",groups = Update.class)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
