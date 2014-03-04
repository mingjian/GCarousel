
package com.mj.gwt.carousel.javascripts;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;




public interface Javascript extends ClientBundle{
    
    public static Javascript INSTANCE = GWT.create (Javascript.class);
    
    @Source("jquery.jcarousel-core.js")
    public TextResource getCore();
    
    @Source("jquery.jcarousel-autoscroll.js")
    public TextResource getAutoScroll();
    
    @Source("jquery.jcarousel-control.js")
    public TextResource getControl();
    
    @Source("jquery.jcarousel-pagination.js")
    public TextResource getPagination();
    
    @Source("jquery.jcarousel-scrollintoview.js")
    public TextResource getScrollInToView();
    
}
