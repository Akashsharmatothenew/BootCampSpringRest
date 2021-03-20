package com.SpringWithJpa1.Employee2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ttn on 17/3/21.
 */
@Service
public class PaymentServices {
    @Autowired
    PaymentRepository paymentRepository;

    public void cardPayment(){
        Creditcard creditcard = new Creditcard();
        creditcard.setId(1);
        creditcard.setAmount(1000);
        creditcard.setCardnumber("123451");
        paymentRepository.save(creditcard);
    }
    public void checkPayment(){
        Checkbook check = new Checkbook();
        check.setId(2);
        check.setAmount(1200);
        check.setChecknumber("123452");
        paymentRepository.save(check);
    }
}
