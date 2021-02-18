package com.company.petclininc.web.screens.bpm.treatment.start;

import com.company.petclininc.entity.Visit;
import com.haulmont.addon.bproc.web.processform.OutputVariable;
import com.haulmont.addon.bproc.web.processform.ProcessForm;
import com.haulmont.addon.bproc.web.processform.ProcessFormContext;
import com.haulmont.addon.bproc.web.processform.ProcessVariable;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.TextArea;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;

@UiController("petclininc_TreatmentStart")
@UiDescriptor("treatment-start.xml")
@LoadDataBeforeShow
@ProcessForm (
        outputVariables = {
                @OutputVariable(name = "doctor", type = User.class),
                @OutputVariable(name = "nurse", type = User.class),
                @OutputVariable(name = "treatmentDescription", type = String.class),
                @OutputVariable(name = "visit", type = Visit.class)
        }
)
public class TreatmentStart extends Screen {

    @Inject
    private ProcessFormContext processFormContext;

    @Inject
    @ProcessVariable(name = "doctor")
    private LookupField<User> doctorLookup;

    @Inject
    @ProcessVariable(name = "nurse")
    private LookupField<User> nurseLookup;

    @Inject
    @ProcessVariable(name = "treatmentDescription")
    private TextArea<String> treatmentDescription;

    @Inject
    @ProcessVariable(name = "visit")
    private LookupField<Visit> visitLookup;

    @Subscribe("startTreatment")
    public void onStartTreatmentClick(Button.ClickEvent event) {
        processFormContext.processStarting().saveInjectedProcessVariables().start();
        closeWithDefaultAction();
    }



}