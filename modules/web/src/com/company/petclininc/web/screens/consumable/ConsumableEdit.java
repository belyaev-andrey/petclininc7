package com.company.petclininc.web.screens.consumable;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.Consumable;

@UiController("petclininc_Consumable.edit")
@UiDescriptor("consumable-edit.xml")
@EditedEntityContainer("consumableDc")
@LoadDataBeforeShow
public class ConsumableEdit extends StandardEditor<Consumable> {
}