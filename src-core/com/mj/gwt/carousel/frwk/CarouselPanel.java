
package com.mj.gwt.carousel.frwk;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;


public abstract class CarouselPanel implements IsWidget {

    private FlowPanel container = new FlowPanel ();
    
    private UnorderedList list = new UnorderedList ();
    
    public CarouselPanel () {
        
        ArrayList<Image> images = getImages ();
        
        for (Image img: images) {
        
            addImage (img);
        }        
    }
    
    abstract ArrayList<Image> getImages();
    
    protected void addImage(Image img){
        ListItem li = new ListItem ();
        li.add (img);
        list.add (li);
    }
    
    protected void createControls(){
        
    }
    
    protected void createPaginations(){
        
    }
    
    @Override
    public Widget asWidget () {
        return container;
    }
    
}
