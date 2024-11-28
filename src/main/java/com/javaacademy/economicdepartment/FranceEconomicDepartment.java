package com.javaacademy.economicdepartment;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;


@Profile("france")
public class FranceEconomicDepartment extends EconomicDepartment {

    private static final long ONE_YEAR_ENERGY = 1_000_000_000;

    @Value("${incomebase}")
    private BigDecimal incomeBase;
    @Value("${currency}")
    private String currency;
    private BigDecimal income = BigDecimal.ONE;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        long n = countElectricity / ONE_YEAR_ENERGY;
        long balance = countElectricity - ONE_YEAR_ENERGY * n;
        income = BigDecimal.valueOf(ONE_YEAR_ENERGY).multiply(incomeBase);
        BigDecimal val = BigDecimal.valueOf(0.99);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.println(income);
            }
            if (i == 1) {
                income = income.multiply(val);
                ;
                System.out.println(income);
            } else {
                income = income.add(income.multiply(val));
                System.out.println(income);
            }
        }
        return income;
    }
}

