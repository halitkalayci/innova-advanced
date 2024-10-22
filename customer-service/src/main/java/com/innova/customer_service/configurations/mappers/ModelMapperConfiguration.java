package com.innova.customer_service.configurations.mappers;

import com.innova.customer_service.business.common.mapping.ModelMapperManager;
import com.innova.customer_service.business.common.mapping.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }


}
