package com.company.petclininc.service;

import com.company.petclininc.entity.Visit;

import java.math.BigDecimal;

public interface VisitService {
    String NAME = "petclininc_VisitService";

    BigDecimal calculateAmount(Visit visit);

}