package com.company.petclininc.web.screens.visit;

import com.company.petclininc.entity.Consumable;
import com.company.petclininc.service.VisitService;
import com.haulmont.cuba.gui.model.CollectionChangeType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.Visit;

import javax.inject.Inject;

@UiController("petclininc_Visit.edit")
@UiDescriptor("visit-edit.xml")
@EditedEntityContainer("visitDc")
@LoadDataBeforeShow
public class VisitEdit extends StandardEditor<Visit> {


    @Inject
    private VisitService visitService;

    @Subscribe(id = "visitDc", target = Target.DATA_CONTAINER)
    public void onVisitDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Visit> event) {
        if (event.getProperty().equals("duration")) {
            getEditedEntity().setAmount(visitService.calculateAmount(getEditedEntity()));
        }
    }

    @Subscribe(id = "consumablesDc", target = Target.DATA_CONTAINER)
    public void onConsumablesDcCollectionChange(CollectionContainer.CollectionChangeEvent<Consumable> event) {
        if (event.getChangeType() != CollectionChangeType.REFRESH) {
            getEditedEntity().setAmount(visitService.calculateAmount(getEditedEntity()));
        }
    }

}