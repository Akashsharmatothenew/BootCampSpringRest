package com.SpringCoreConcept2.question5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by ttn on 4/3/21.
 */
@SpringBootApplication

public class Question4 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Question4.class,args);
        BinarySearch binarySearch=  applicationContext.getBean(BinarySearch.class);
        int number[]={1,2,6,4,9,5,7,10};
        int find = 4;
        int result =binarySearch.binarySerch(number,find);
        if(result==-1){
            System.out.println("Not Present");
        }
        else System.out.println("Find Element "+ find);
    }
}
