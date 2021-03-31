package com.project.ecommerce.projectEcommerce.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ChildCategoryNotFoundException extends RuntimeException{
    public ChildCategoryNotFoundException(String message) {
        super(message);
    }
}
