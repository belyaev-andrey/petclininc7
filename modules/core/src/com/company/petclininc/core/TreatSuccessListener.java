package com.company.petclininc.core;

import com.company.petclininc.entity.Visit;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component(TreatSuccessListener.NAME)
public class TreatSuccessListener implements ExecutionListener {

    public static final String NAME = "petclininc_TreatSuccessListener";

    @Override
    public void notify(DelegateExecution execution) {
        Visit visit = (Visit)execution.getVariable("visit");
        DataManager dataManager = AppBeans.get(DataManager.class);
        final Visit reload = dataManager.reload(visit, "visit-full");
        System.out.println(reload.getPet().getOwner().getEmail());
    }
}