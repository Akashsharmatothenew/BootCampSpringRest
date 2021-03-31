package com.project.ecommerce.projectEcommerce.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryMetadataFieldNotFoundException extends RuntimeException{
    public  CategoryMetadataFieldNotFoundException(String message){
        super(message);
    }
}
