package com.company;

import java.util.Date;

enum BookStatus {
    AVAILABLE,
    RESERVED,
    LOANED,
    LOST
     }

    class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    }

    class Person {
    private String name;
    private Address address;
    private String email;
    private String phone;
    }

    abstract class Account {
    private String id;
    private String password;
    private Person person;

    //public boolean resetPassword();
    }
    class Librarian extends Account {
        private String Staff;

    }

    class Student extends Account {
    private Date dateOfMembership;
    private int totalBooksCheckedout;
    private String course;
    
    public int getTotalBooksCheckedout(){
        return 0;
    }
    }


public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
