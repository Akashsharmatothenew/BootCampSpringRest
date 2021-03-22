package com.SpringWithJpa1.Employee2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ttn on 17/3/21.
 */
@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public void cardPayment(){
        Creditcard3 creditcard3 = new Creditcard3();
        creditcard3.setId(1);
        creditcard3.setAmount(1000);
        creditcard3.setCardnumber("123451");
        paymentRepository.save(creditcard3);
    }
    public void checkPayment(){
        Checkbook3 checkbook3 = new Checkbook3();
        checkbook3.setId(2);
        checkbook3.setAmount(1200);
        checkbook3.setChecknumber("123452");
        paymentRepository.save(checkbook3);
    }

}
