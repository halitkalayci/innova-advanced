package com.innova.customer_service.utils.exceptions.problemDetails;

public class BusinessProblemDetails extends ProblemDetail {
    public BusinessProblemDetails(){
        setTitle("Business Rule Violation");
        setType("http://mydomain.com/exceptions/business");
        setStatus("400");
    }
}
