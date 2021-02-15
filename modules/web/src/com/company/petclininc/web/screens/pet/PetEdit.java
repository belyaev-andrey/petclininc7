package com.company.petclininc.web.screens.pet;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.Pet;

@UiController("petclininc_Pet.edit")
@UiDescriptor("pet-edit.xml")
@EditedEntityContainer("petDc")
@LoadDataBeforeShow
public class PetEdit extends StandardEditor<Pet> {
}