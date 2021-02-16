package com.company.petclininc.web.screens.main;

import com.company.petclininc.entity.Pet;
import com.company.petclininc.entity.Visit;
import com.company.petclininc.web.screens.visit.VisitEdit;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Calendar;
import com.haulmont.cuba.gui.components.EditorScreenFacet;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.main.MainScreen;

import javax.inject.Inject;
import java.time.LocalDateTime;


@UiController("extMainScreen")
@UiDescriptor("ext-main-screen.xml")
@LoadDataBeforeShow
public class ExtMainScreen extends MainScreen {

    @Inject
    private DataManager dataManager;
    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private EditorScreenFacet<Visit, VisitEdit> visitScreen;

    @Subscribe("scheduleAction")
    public void onScheduleAction(Action.ActionPerformedEvent event) {

    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        visitScreen.addAfterCloseEventListener( e -> {
            getScreenData().loadAll();
        });
    }


    @Subscribe("reloadAction")
    public void onReloadAction(Action.ActionPerformedEvent event) {
        getScreenData().loadAll();
    }

    @Subscribe("visitsCalendar")
    public void onVisitsCalendarCalendarEventClick(Calendar.CalendarEventClickEvent<LocalDateTime> event) {

        final Screen screen = screenBuilders.editor(Visit.class, this)
                .withOpenMode(OpenMode.DIALOG)
                .editEntity((Visit) event.getEntity())
                .build();

        screen.addAfterCloseListener(e -> {
            getScreenData().loadAll();
        });

        screen.show();

    }



}