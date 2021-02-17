com_company_petclinic_web_screens_visit_edit = function () {

    var connector = this;

    var element = connector.getElement();

    element.innerHTML = "<div id='editor'></div>"

    connector.onStateChange = function() {

        var state = connector.getState();
        var data = state.data;

        var quill = new Quill('#editor', data.options);

        quill.on('text-change', function (delta, oldContents, source) {
            console.log(source);

            if (source === 'user') {
                connector.valueChanged(quill.getText(), quill.getContents())
            }
        });

        connector.setText = function (txt) {
            console.log(txt);
            quill.setText(txt, 'api');
        }


    }

}