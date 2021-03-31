package com.project.ecommerce.projectEcommerce.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class ProductVariationNotFoundException extends Throwable {
    public ProductVariationNotFoundException(String message) {
        super(message);
    }
}
