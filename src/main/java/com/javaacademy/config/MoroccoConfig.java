package com.javaacademy.config;

import com.javaacademy.economicdepartment.MoroccoEconomicDepartment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("morocco")
public class MoroccoConfig {

    @Bean
    public MoroccoEconomicDepartment moroccoEconomicDepartment() {
        return new MoroccoEconomicDepartment();
    }

}
