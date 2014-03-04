
package com.mj.resources.javascripts;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.ScriptElement;

public class JavascriptInjector {

    private static HeadElement head;


    public static void inject (final String javascript) {

        HeadElement head = getHead ();
        ScriptElement scriptElement = createScriptElement (javascript);
        head.appendChild (scriptElement);
    }


    private static ScriptElement createScriptElement (final String javascript) {
        ScriptElement element = Document.get ().createScriptElement ();
        element.setAttribute ("language", "javascript");
        element.setText (javascript);
        return element;
    }


    private static HeadElement getHead () {

        if (head == null) {
            Element element = Document.get ().getElementsByTagName ("head").getItem (0);
            assert element != null: "HTML Head element required";
            HeadElement head = HeadElement.as (element);
            JavascriptInjector.head = head;
        }

        return JavascriptInjector.head;
    }

}
