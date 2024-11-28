package com.javaacademy.config;


import com.javaacademy.economicdepartment.FranceEconomicDepartment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("france")
public class FranceConfig {

    @Bean
    public FranceEconomicDepartment franceEconomicDepartment() {
        return new FranceEconomicDepartment();
    }

}
