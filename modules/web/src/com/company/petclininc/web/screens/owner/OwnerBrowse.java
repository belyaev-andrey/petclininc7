package com.company.petclininc.web.screens.owner;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.Owner;

@UiController("petclininc_Owner.browse")
@UiDescriptor("owner-browse.xml")
@LookupComponent("ownersTable")
@LoadDataBeforeShow
public class OwnerBrowse extends StandardLookup<Owner> {
}