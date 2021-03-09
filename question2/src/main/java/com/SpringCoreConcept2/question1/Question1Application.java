package com.SpringCoreConcept2.question1;

import org.springframework.boot.SpringApplication;

/**
 * Created by ttn on 3/3/21.
 */
public class Question1Application {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int number[]={1,2,6,4,9,5,7,10};
        int find = 4;
        int result = binarySearch.binarySerch(number,find);
        if(result==-1){
            System.out.println("Not Present");
        }
        else System.out.println("Find Element "+ find);
        SpringApplication.run(Question1Application.class, args);
    }
}
