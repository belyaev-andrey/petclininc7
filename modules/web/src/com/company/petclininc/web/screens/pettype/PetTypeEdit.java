package com.company.petclininc.web.screens.pettype;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.PetType;

@UiController("petclininc_PetType.edit")
@UiDescriptor("pet-type-edit.xml")
@EditedEntityContainer("petTypeDc")
@LoadDataBeforeShow
@DialogMode(forceDialog = true)
public class PetTypeEdit extends StandardEditor<PetType> {
}