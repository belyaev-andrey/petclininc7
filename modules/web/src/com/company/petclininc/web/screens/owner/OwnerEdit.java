package com.company.petclininc.web.screens.owner;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.Owner;

@UiController("petclininc_Owner.edit")
@UiDescriptor("owner-edit.xml")
@EditedEntityContainer("ownerDc")
@LoadDataBeforeShow
public class OwnerEdit extends StandardEditor<Owner> {
}