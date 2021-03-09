package com.SpringwithRest1.RestSpring.Q6;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ttn on 8/3/21.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String s) {
        super(s);
    }
}
