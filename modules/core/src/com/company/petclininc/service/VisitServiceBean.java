package com.company.petclininc.service;

import com.company.petclininc.entity.Consumable;
import com.company.petclininc.entity.Visit;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service(VisitService.NAME)
public class VisitServiceBean implements VisitService {

    @Override
    public BigDecimal calculateAmount(Visit visit) {
        BigDecimal amount = BigDecimal.ZERO;

        if (visit.getDuration() != null) {
            amount = amount.add(BigDecimal.valueOf(visit.getDuration()).multiply(visit.getVeterinarian().getHourlyRate()));
        }

        if (visit.getConsumables() != null) {
            for (Consumable c : visit.getConsumables()) {
                amount = amount.add(c.getPrice());
            }
        }

        return amount;
    }
}