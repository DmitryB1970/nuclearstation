package com.javaacademy;

import com.javaacademy.economicdepartment.FranceEconomicDepartment;
import com.javaacademy.exception.NuclearFuelIsEmptyException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Runner {

    public static void main(String[] args) throws NuclearFuelIsEmptyException {
        ConfigurableApplicationContext context = SpringApplication.run(Runner.class, args);
        ReactorDepartment reactorDepartment = context.getBean(ReactorDepartment.class);
        NuclearStation nuclearStation = context.getBean(NuclearStation.class);
        nuclearStation.start(3);

        FranceEconomicDepartment france = context.getBean(FranceEconomicDepartment.class);

        System.out.println(france.computeYearIncomes(3_000_000_000L));
    }
}
