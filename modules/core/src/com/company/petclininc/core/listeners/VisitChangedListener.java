package com.company.petclininc.core.listeners;

import com.company.petclininc.entity.Visit;
import com.haulmont.cuba.core.app.events.AttributeChanges;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.entity.contracts.Id;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.UUID;

@Component("petclininc_VisitChangedListener")
public class VisitChangedListener {

    @Inject
    private DataManager dataManager;

    @Inject
    private Logger log;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(EntityChangedEvent<Visit, UUID> event) {
        final AttributeChanges attributeChanges = event.getChanges();
        if (attributeChanges.isChanged("date")) {
            final Id<Visit, UUID> entityId = event.getEntityId();
            final Visit visit = dataManager.load(entityId).view(View.LOCAL).one();
            final String description = visit.getDescription();
            log.info("Visit date has changed to "+visit.getDate()+" description:"+description);
        }


    }
}