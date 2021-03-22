package com.SpringWithJpa1.Employee2.Q1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ttn on 17/3/21.
 */
@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public void creditCardPayment(){
        CreditCard creditCard = new CreditCard();
        creditCard.setAmount(1000);
        creditCard.setCreditnumber("123453");
        paymentRepository.save(creditCard);
    }
    public void checkBookPayment(){
        CheckBook check = new CheckBook();
        check.setAmount(1000);
        check.setChecknumber("123454");
        paymentRepository.save(check);
    }
}
