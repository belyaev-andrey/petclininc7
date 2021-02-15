package com.company.petclininc.web.screens.visit;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclininc.entity.Visit;

@UiController("petclininc_Visit.browse")
@UiDescriptor("visit-browse.xml")
@LookupComponent("visitsTable")
@LoadDataBeforeShow
public class VisitBrowse extends StandardLookup<Visit> {
}