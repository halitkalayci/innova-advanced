package com.innova.customer_service.utils.exceptions.problemDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.kafka.common.protocol.types.Field;

import java.util.Map;

@Data
public class ValidationProblemDetails extends ProblemDetail{
    public ValidationProblemDetails(){
        setTitle("Validation Rule Violation");
        setDetail("Validation Problem(s)");
        setType("http://mydomain.com/exceptions/validation");
        setStatus("400");
    }

    private Map<String, String> errors;
}
