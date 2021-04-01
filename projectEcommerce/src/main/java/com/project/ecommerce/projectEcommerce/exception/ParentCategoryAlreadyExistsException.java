package com.project.ecommerce.projectEcommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ParentCategoryAlreadyExistsException extends RuntimeException{
    public ParentCategoryAlreadyExistsException(String s) {
    }
}
