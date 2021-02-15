package com.company.petclininc.web.screens.pet;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.Pet;

@UiController("petclininc_Pet.browse")
@UiDescriptor("pet-browse.xml")
@LookupComponent("petsTable")
@LoadDataBeforeShow
public class PetBrowse extends StandardLookup<Pet> {
}