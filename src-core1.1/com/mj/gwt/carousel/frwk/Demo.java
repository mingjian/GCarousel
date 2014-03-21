package com.mj.gwt.carousel.frwk;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.mj.gwt.carousel.frwk.ui.GCarouselPanel;
import com.mj.gwt.carousel.images.Images;

public class Demo implements EntryPoint {


    public void onModuleLoad () {


        GCarouselPanel core = new GCarouselPanel ();
        Image img = new Image (Images.INSTANCE.getImage1 ());
        core.addImage (img);
        img = new Image (Images.INSTANCE.getImage2 ());
        core.addImage (img);
        RootPanel.get ().add (core);

    }

}
