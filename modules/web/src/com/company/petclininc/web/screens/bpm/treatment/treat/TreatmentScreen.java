package com.company.petclininc.web.screens.bpm.treatment.treat;

import com.company.petclininc.entity.Visit;
import com.haulmont.addon.bproc.web.processform.*;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.TextArea;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("petclininc_TreatmentScreen")
@UiDescriptor("treatment-screen.xml")
@LoadDataBeforeShow
@ProcessForm (
        outcomes = {
                @Outcome(id = "success"),
                @Outcome(id = "hasQuestions", outputVariables = {
                        @OutputVariable(name = "treatmentQuestion", type = String.class)
                })
        }
)
public class TreatmentScreen extends Screen {

    @Inject
    private ProcessFormContext processFormContext;

    @Inject
    @ProcessVariable(name = "treatmentDescription")
    private TextArea<String> treatmentDescription;

    @Inject
    @ProcessVariable(name = "visit")
    private LookupField<Visit> visitLookup;

    @Inject
    @ProcessVariable(name = "treatmentQuestion")
    private TextArea<String> treatmentQuestion;

    @Subscribe("finishTreatment")
    public void onFinishTreatmentClick(Button.ClickEvent event) {
        processFormContext.taskCompletion().withOutcome("success").complete();
        closeWithDefaultAction();
    }

    @Subscribe("hasQuestions")
    public void onHasQuestionsClick(Button.ClickEvent event) {
        processFormContext.taskCompletion()
                .withOutcome("hasQuestions")
                .addProcessVariable("treatmentQuestion", treatmentQuestion.getValue())
                .complete();
        closeWithDefaultAction();
    }

}