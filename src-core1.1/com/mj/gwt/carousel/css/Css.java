
package com.mj.gwt.carousel.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;


public interface Css extends ClientBundle{
    
    public static Css INSTANCE = GWT.create (Css.class);
    
    @Source("carousel.css")
    @NotStrict
    public CssResource getCarousel();
    
}
