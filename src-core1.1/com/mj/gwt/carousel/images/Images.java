
package com.mj.gwt.carousel.images;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Images extends ClientBundle {

    public static Images INSTANCE = GWT.create (Images.class);


    @Source ("img1.jpg")
    public ImageResource getImage1 ();


    @Source ("img2.jpg")
    public ImageResource getImage2 ();
}
