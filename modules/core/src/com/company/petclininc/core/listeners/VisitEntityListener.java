package com.company.petclininc.core.listeners;

import com.company.petclininc.entity.Visit;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component(VisitEntityListener.NAME)
public class VisitEntityListener implements BeforeInsertEntityListener<Visit> {
    public static final String NAME = "petclininc_VisitEntityListener";

    @Inject
    private UniqueNumbersAPI uniqueNumbersAPI;

    @Override
    public void onBeforeInsert(Visit entity, EntityManager entityManager) {
        entity.setNumber(uniqueNumbersAPI.getNextNumber("VISIT"));
    }
}