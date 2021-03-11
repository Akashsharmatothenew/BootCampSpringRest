package com.SpringwithRest1.RestSpring.Q2;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by ttn on 7/3/21.
 */
@ApiModel(description = "This is class to details of User.  ")
public class User {
    Integer id;
    @ApiModelProperty(notes = "Name should be min 3 character")
    @Size(min=3)
    String name;
    @Min(18)
            @ApiModelProperty(notes = "Age Should be greater than 18")
    int age;

    User(){

    }
    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
