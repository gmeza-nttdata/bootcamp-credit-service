package com.nttdata.bootcamp.creditservice.infrastructure.spring.config;

import com.nttdata.bootcamp.creditservice.application.model.CreditRepository;
import com.nttdata.bootcamp.creditservice.infrastructure.repository.CreditCrudRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SpringConfiguration {
    @Bean
    @Primary
    public CreditRepository repository(){
        return new CreditCrudRepository();
    }
        
}
