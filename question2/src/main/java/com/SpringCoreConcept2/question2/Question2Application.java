package com.SpringCoreConcept2.question2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Question2Application {

	public static void main(String[] args) {
         BinarySerch binarySerch = new BinarySerch(new QuickSort());

		int number[]={1,2,6,4,9,5,7,10};
		int find = 5;
		int result =binarySerch.binarySerch(number,find);
		if(result==-1){
			System.out.println("Not Present");
		}
		else System.out.println("Find Element "+ find);
		SpringApplication.run(Question2Application.class, args);
	}

}
