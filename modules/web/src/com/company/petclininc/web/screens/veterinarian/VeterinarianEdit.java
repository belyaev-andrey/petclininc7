package com.company.petclininc.web.screens.veterinarian;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.Veterinarian;

@UiController("petclininc_Veterinarian.edit")
@UiDescriptor("veterinarian-edit.xml")
@EditedEntityContainer("veterinarianDc")
@LoadDataBeforeShow
public class VeterinarianEdit extends StandardEditor<Veterinarian> {
}