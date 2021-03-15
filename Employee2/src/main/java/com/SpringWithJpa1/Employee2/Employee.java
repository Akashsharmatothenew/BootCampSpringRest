package com.SpringWithJpa1.Employee2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ttn on 15/3/21.
 */
@Entity
public class Employee {
        String name;
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        int id;
        int age;
        String location;

        public Employee() {
        }

        public Employee(String name,int id, int age, String location) {
            this.name = name;
            this.id =id;
            this.age = age;
            this.location = location;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

}
