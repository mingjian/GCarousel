package com.mj.gwt.carousel.frwk.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class Paragraph extends ComplexPanel {

    public Paragraph () {
        setElement (DOM.createElement ("P"));
    }


    public void add (Widget w) {
        super.add (w, getElement ());
    }


    public void insert (Widget w, int beforeIndex) {
        super.insert (w, getElement (), beforeIndex, true);
    }

}
