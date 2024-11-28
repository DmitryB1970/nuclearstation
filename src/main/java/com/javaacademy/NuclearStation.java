package com.javaacademy;


import com.javaacademy.economicdepartment.EconomicDepartment;
import com.javaacademy.exception.NuclearFuelIsEmptyException;
import com.javaacademy.exception.ReactorWorkException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NuclearStation {

    @Autowired
    private ReactorDepartment reactorDepartment;
    private long totalProducedEnergy;
    private int day;
    private int accidentCountAllTime;
    @Autowired
    private SecurityDepartment securityDepartment;
    @Autowired
    EconomicDepartment economicDepartment;


    public NuclearStation(@Lazy SecurityDepartment securityDepartment) {
        this.securityDepartment = securityDepartment;
    }

    public int incrementAccident(int count) {
        return accidentCountAllTime += count;
    }

    public void startYear() {
        log.info("Атомная станция начала работу");
        totalProducedEnergy = 0;
        day = 0;
        for (int i = 0; i < 365; i++) {
            if (reactorDepartment.getDay() == 365) {
                reactorDepartment.setDay(0);
            }
            try {
                totalProducedEnergy += reactorDepartment.run();
                reactorDepartment.stop();
            } catch (NuclearFuelIsEmptyException | ReactorWorkException e) {
                log.info("Внимание! Происходят работы на атомной станции! Электричества нет!");
            }
        }
        log.info("Количество инцидентов за год: {}", securityDepartment.getCountAccidents());
        log.info("Атомная станция закончила работу. За год Выработано {} киловатт/часов", totalProducedEnergy);
        securityDepartment.reset();
        log.info("Количество инцидентов за период {}", accidentCountAllTime);
    }

    public void start(int year) {
        log.info("Действие происходит в стране: {}", economicDepartment);
        for (int i = 0; i < year; i++) {
            startYear();
        }
    }
}
