package com.javaacademy.economicdepartment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;


@Profile("morocco")
public class MoroccoEconomicDepartment extends EconomicDepartment {

    @Value("${incomebase}")
    private BigDecimal incomeBase;
    @Value("${currency}")
    private String currency;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        return null;
    }
}
