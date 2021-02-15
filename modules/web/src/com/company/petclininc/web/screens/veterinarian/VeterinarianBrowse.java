package com.company.petclininc.web.screens.veterinarian;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.Veterinarian;

@UiController("petclininc_Veterinarian.browse")
@UiDescriptor("veterinarian-browse.xml")
@LookupComponent("veterinariansTable")
@LoadDataBeforeShow
public class VeterinarianBrowse extends StandardLookup<Veterinarian> {
}