package com.SpringCoreConcept2.question6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by ttn on 4/3/21.
 */
@SpringBootApplication
public class Question5 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Question5.class);
        BinarySearch binarySearch = applicationContext.getBean(BinarySearch.class);
        int number[]={1,2,6,4,9,5,7,10};
        int find = 5;
        int result =binarySearch.binarySerch(number,find);
        if(result==-1){
            System.out.println("Not Present");
        }
        else System.out.println("Find Element "+ find);
    }
}
