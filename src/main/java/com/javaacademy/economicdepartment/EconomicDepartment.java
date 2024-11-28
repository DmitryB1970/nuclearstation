package com.javaacademy.economicdepartment;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public abstract class EconomicDepartment {

    public abstract BigDecimal computeYearIncomes(long countElectricity);
}
