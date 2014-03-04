package com.mj.gwt.carousel.frwk;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mj.gwt.carousel.css.Css;
import com.mj.gwt.carousel.images.Images;
import com.mj.gwt.carousel.javascripts.Javascript;
import com.mj.resources.javascripts.JavascriptInjector;


public class Demo implements EntryPoint {

    private FlowPanel top = new FlowPanel ();

    private FlowPanel layout = new FlowPanel ();


    
    
    public void onModuleLoad () {

        init ();

        top.setStyleName ("wrapper");

        layout.setStyleName ("jcarousel-wrapper");

        layout.add (createCarouselCore ());

        Anchor left = new Anchor ();
        left.setText ("<");
        left.setStyleName ("jcarousel-control-prev");
        layout.add (left);

        Anchor right = new Anchor ();
        right.setText (">");
        right.setStyleName ("jcarousel-control-next");
        layout.add (right);

        Paragraph pagination = new Paragraph ();
        pagination.setStyleName ("jcarousel-pagination");
        layout.add (pagination);
        top.add (layout);

        RootPanel.get ().add (top);

        bind ();
    }


    private void bind () {

        GCarousel.renderByCSS ("jcarousel");
        GCarousel.controlLeft ("jcarousel-control-prev");
        GCarousel.controlRight ("jcarousel-control-next");
        Scheduler.get ().scheduleFixedDelay (new RepeatingCommand () {
            
            native boolean check () /*-{
        		// return true when all 3party js properties are available
        		return !!$wnd.jQuery('.jcarousel-pagination');
            }-*/;
            
            public boolean execute () {
                if (check ()) {
                    GCarousel.pagination ();
                    return false;
                } else {
                    return true;
                }
            }
        }, 100);

    }


    private Widget createCarouselCore () {

        FlowPanel div = new FlowPanel ();
        div.setStyleName ("jcarousel");
        // creat list
        UnorderedList ul = new UnorderedList ();
        ListItem li = new ListItem ();
        Image img = new Image (Images.INSTANCE.getImage1 ());
        li.add (img);
        ul.add (li);
        li = new ListItem ();
        img = new Image (Images.INSTANCE.getImage2 ());
        li.add (img);
        ul.add (li);
        div.add (ul);

        return div;
    }


    public void init () {
        JavascriptInjector.inject (Javascript.INSTANCE.getCore ().getText ());
        JavascriptInjector.inject (Javascript.INSTANCE.getAutoScroll ().getText ());
        JavascriptInjector.inject (Javascript.INSTANCE.getControl ().getText ());
        JavascriptInjector.inject (Javascript.INSTANCE.getPagination ().getText ());
        JavascriptInjector.inject (Javascript.INSTANCE.getScrollInToView ().getText ());

        Css.INSTANCE.getCarousel ().ensureInjected ();
    }
}
