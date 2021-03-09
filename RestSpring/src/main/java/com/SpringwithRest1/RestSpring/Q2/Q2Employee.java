package com.SpringwithRest1.RestSpring.Q2;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by ttn on 7/3/21.
 */
public class Q2Employee {
    Integer id;
    @Size(min=3)
    String name;
    @Min(18)
    int age;

    /*Q2Employee(){

    }*/
    public Q2Employee(int id, String name, int age) {
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
        return "Q2Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
