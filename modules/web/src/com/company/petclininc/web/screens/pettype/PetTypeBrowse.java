package com.company.petclininc.web.screens.pettype;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.PetType;

import javax.inject.Inject;

@UiController("petclininc_PetType.browse")
@UiDescriptor("pet-type-browse.xml")
@LookupComponent("petTypesTable")
@LoadDataBeforeShow
public class PetTypeBrowse extends StandardLookup<PetType> {


    @Inject
    private Notifications notifications;
    @Inject
    private MessageBundle messageBundle;
    @Inject
    private GroupTable<PetType> petTypesTable;

    @Subscribe("petTypesTable.helloAction")
    public void onPetTypesTableHelloAction(Action.ActionPerformedEvent event) {
        notifications.create(Notifications.NotificationType.HUMANIZED)
                .withCaption(String.format(messageBundle.getMessage("hello.string"), petTypesTable.getSingleSelected().getName()))
                .show();
    }

    @Install(to = "petTypesTable.helloAction", subject = "enabledRule")
    private boolean petTypesTableHelloActionEnabledRule() {
        return petTypesTable.getSingleSelected() != null;
    }
}