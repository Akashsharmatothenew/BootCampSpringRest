package com.SpringWithJpa1.Employee2;

import javax.persistence.*;

/**
 * Created by ttn on 15/3/21.
 */
@Entity

@Table(name ="employeeTable")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "empid")
    int id;
    @Column(name = "empFirstName")
    String firstName;
    @Column(name = "empLastName")
    String lastname;
    @Column(name = "empSalary")
    int salary;
    @Column(name = "empAge")
    int age;

    public Employee() {
    }

    public Employee(String firstName, String lastname, int salary, int age) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
