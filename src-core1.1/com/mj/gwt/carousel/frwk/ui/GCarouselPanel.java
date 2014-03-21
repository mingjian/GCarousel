
package com.mj.gwt.carousel.frwk.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.mj.gwt.carousel.css.Css;
import com.mj.gwt.carousel.frwk.GCarousel;
import com.mj.gwt.carousel.javascripts.Javascript;
import com.mj.resources.javascripts.JavascriptInjector;

public class GCarouselPanel extends Composite {

    private static GCarouselPanelUiBinder uiBinder = GWT.create (GCarouselPanelUiBinder.class);

    interface GCarouselPanelUiBinder extends UiBinder<Widget, GCarouselPanel> {}

    /**
     * Because this class has a default constructor, it can
     * be used as a binder template. In other words, it can be used in other
     * *.ui.xml files as follows:
     * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
     *   xmlns:g="urn:import:**user's package**">
     *  <g:**UserClassName**>Hello!</g:**UserClassName>
     * </ui:UiBinder>
     * Note that depending on the widget that is used, it may be necessary to
     * implement HasHTML instead of HasText.
     */
    public GCarouselPanel () {
        injectResources ();
        initWidget (uiBinder.createAndBindUi (this));  
        prev.setText ("<");
        next.setText (">");
        bindJavaScripts ();
    }

    public void injectResources () {
        Css.INSTANCE.getCarousel ().ensureInjected ();
        JavascriptInjector.inject (Javascript.INSTANCE.getCore ().getText ());
        JavascriptInjector.inject (Javascript.INSTANCE.getAutoScroll ().getText ());
        JavascriptInjector.inject (Javascript.INSTANCE.getControl ().getText ());
        JavascriptInjector.inject (Javascript.INSTANCE.getPagination ().getText ());
        JavascriptInjector.inject (Javascript.INSTANCE.getScrollInToView ().getText ());

    }

    public void bindJavaScripts () {
        GCarousel.carouselByPath ("jcarousel");
        GCarousel.controlLeft ("jcarousel-control-prev");
        GCarousel.controlRight ("jcarousel-control-next");
        GCarousel.pagination ("jcarousel-pagination");
    }

    @UiField
    FlowPanel container;
    
    @UiField
    FlowPanel wrapper;
    
    @UiField
    FlowPanel core;
    
    @UiField 
    UnorderedList ul;
    
    @UiField
    Anchor prev;
    
    @UiField
    Anchor next;    
    
    @UiField
    Paragraph pagination;
    
    public void addImage(Image img){
        
        ListItem li = new ListItem ();
        
        li.add (img);
        
        ul.add (li);
        
        
    }

}
