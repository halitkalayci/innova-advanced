package com.innova.customer_service.utils.exceptions.types;

public class BusinessException extends RuntimeException {
    public BusinessException(String message){
        super(message);
    }
}
