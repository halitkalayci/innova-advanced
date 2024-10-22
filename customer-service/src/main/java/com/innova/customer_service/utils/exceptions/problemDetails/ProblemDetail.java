package com.innova.customer_service.utils.exceptions.problemDetails;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetail {
    //rfce standarts
    private String title;
    private String detail;
    private String status;
    private String type;
}
