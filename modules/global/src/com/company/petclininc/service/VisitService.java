package com.company.petclininc.service;

import com.company.petclininc.entity.Consumable;
import com.company.petclininc.entity.Visit;

import java.math.BigDecimal;
import java.util.List;

public interface VisitService {
    String NAME = "petclininc_VisitService";

    BigDecimal calculateAmount(Visit visit);

    List<Consumable> getUsedConsumables();

}