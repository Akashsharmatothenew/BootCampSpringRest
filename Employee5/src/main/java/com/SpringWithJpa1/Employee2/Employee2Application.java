package com.SpringWithJpa1.Employee2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Employee2Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext =SpringApplication.run(Employee2Application.class, args);
	    PaymentServices paymentServices = applicationContext.getBean(PaymentServices.class);
	    paymentServices.checkPayment();
	    paymentServices.cardPayment();

	}

}
