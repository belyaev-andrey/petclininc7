package com.company.petclininc.web.screens.pettype;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.PetType;

@UiController("petclininc_PetType.browse")
@UiDescriptor("pet-type-browse.xml")
@LookupComponent("petTypesTable")
@LoadDataBeforeShow
public class PetTypeBrowse extends StandardLookup<PetType> {
}