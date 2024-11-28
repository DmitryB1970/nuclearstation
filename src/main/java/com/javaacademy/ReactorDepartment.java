package com.javaacademy;

import com.javaacademy.exception.NuclearFuelIsEmptyException;
import com.javaacademy.exception.ReactorWorkException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReactorDepartment {

    private Status status = Status.NOT_WORK;
    @Getter
    @Setter
    private int day = 0;
    private static final int PRODUCE_PER_DAY = 10_000_000;
    private Long totalEnergy = 0L;
    @Autowired
    private SecurityDepartment securityDepartment;

    public int run() throws ReactorWorkException, NuclearFuelIsEmptyException {
        if (status == Status.WORK) {
            throw new ReactorWorkException("Реактор уже работает");
        }
        day++;
        if (day % 100 == 0) {
            log.error("День: {}", day);
            securityDepartment.addAccident();
            throw new NuclearFuelIsEmptyException();
        }
        status = Status.WORK;
        return PRODUCE_PER_DAY;
    }

    public void stop() throws ReactorWorkException {
        if (status == Status.NOT_WORK) {
            throw new ReactorWorkException("Реактор уже выключен");
        }
        status = Status.NOT_WORK;
    }
}



