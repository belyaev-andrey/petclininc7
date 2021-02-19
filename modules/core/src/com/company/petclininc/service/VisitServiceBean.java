package com.company.petclininc.service;

import com.company.petclininc.entity.Consumable;
import com.company.petclininc.entity.Visit;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import org.flowable.engine.delegate.BpmnError;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Profile("dev")
@Service(VisitService.NAME)
public class VisitServiceBean implements VisitService {

    @Inject
    private Persistence persistence;
    @Inject
    private DataManager dataManager;

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

    @Override
    @Transactional
    public List<Consumable> getUsedConsumables() {
        EntityManager em = persistence.getEntityManager();
        final TypedQuery<Consumable> query = em.createQuery("select distinct c from petclininc_Visit v join v.consumables c " +
                "where @between(c.createTs, now-7, now+1, day)", Consumable.class);
        query.setViewName(View.LOCAL);
        return query.getResultList();
    }

    @Override
    public void setVisitStatus(Visit visit, String status) {
        final Visit reload = dataManager.reload(visit, View.LOCAL);
        if (reload.getDescription().contains("?")) {
            throw new BpmnError("Visit is not correct");
        }
        reload.setStatus(status);
        dataManager.commit(reload);
    }
}