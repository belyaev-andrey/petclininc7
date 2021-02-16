package com.company.petclininc.web.screens.consumable;

import com.company.petclininc.entity.Consumable;
import com.company.petclininc.entity.Visit;
import com.company.petclininc.service.VisitService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.Route;
import com.haulmont.cuba.gui.UrlRouting;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

@UiController("petclininc_UsedConsumablesScreen")
@UiDescriptor("used-consumables-screen.xml")
@LoadDataBeforeShow
@Route("used-consumables")
public class UsedConsumablesScreen extends Screen {

    @Inject
    private VisitService visitService;

    @Install(to = "consumablesDl", target = Target.DATA_LOADER)
    private List<Consumable> consumablesDlLoadDelegate(LoadContext<Consumable> loadContext) {
        return visitService.getUsedConsumables();
    }

}