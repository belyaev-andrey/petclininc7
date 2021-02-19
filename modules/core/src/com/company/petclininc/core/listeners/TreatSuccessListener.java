package com.company.petclininc.core.listeners;

import com.company.petclininc.entity.Visit;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

public class TreatSuccessListener implements ExecutionListener {

    public static final String NAME = "petclininc_TreatSuccessListener";

    public void notify(DelegateExecution execution) {
        Visit visit = (Visit)execution.getVariable("visit");
        DataManager dataManager = AppBeans.get(DataManager.class);
        final Visit reload = dataManager.reload(visit, "visit-full");
        System.out.println(reload.getPet().getOwner().getEmail());
    }
}