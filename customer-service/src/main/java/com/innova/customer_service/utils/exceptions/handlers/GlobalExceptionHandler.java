package com.innova.customer_service.utils.exceptions.handlers;

import com.innova.customer_service.utils.exceptions.problemDetails.BusinessProblemDetails;
import com.innova.customer_service.utils.exceptions.problemDetails.ValidationProblemDetails;
import com.innova.customer_service.utils.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException){
        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
        businessProblemDetails.setDetail(businessException.getMessage());
        return businessProblemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        Map<String,String> validationErrors = new HashMap<>();

        exception.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> validationErrors.put(fieldError.getField(),
                        fieldError.getDefaultMessage())).collect(Collectors.toList());

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setErrors(validationErrors);
        return validationProblemDetails;

    }
}

//Create a product micro service
//do the same for product ->id, name, stockAmount, unitPrice, descrption