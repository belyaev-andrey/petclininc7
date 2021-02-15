package com.company.petclininc.web.screens.consumable;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.Consumable;

@UiController("petclininc_Consumable.browse")
@UiDescriptor("consumable-browse.xml")
@LookupComponent("consumablesTable")
@LoadDataBeforeShow
public class ConsumableBrowse extends StandardLookup<Consumable> {
}