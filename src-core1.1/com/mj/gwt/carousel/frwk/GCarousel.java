package com.mj.gwt.carousel.frwk;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;

public class GCarousel {

    public static void carouselByPath (final String css) {

        final String path = "."+css;
        Scheduler.get ().scheduleFixedDelay (new RepeatingCommand () {

            public boolean execute () {
                if (check (path)) {
                    carousel (path);
                    return false;
                } else {
                    return true;
                }
            }
        }, 100);
    }


    public static void controlLeft (String css) {
        final String path = "." + css;
        Scheduler.get ().scheduleFixedDelay (new RepeatingCommand () {

            public boolean execute () {
                if (check (path)) {
                    carouselControlLeft (path);
                    return false;
                } else {
                    return true;
                }
            }
        }, 100);
    }


    public static void controlRight (String css) {
        final String path = "." + css;
        Scheduler.get ().scheduleFixedDelay (new RepeatingCommand () {

            public boolean execute () {
                if (check (path)) {
                    carouselControlRight (path);
                    return false;
                } else {
                    return true;
                }
            }
        }, 100);
    }


    public static void pagination (String css) {
        final String path = "."+css;
        Scheduler.get ().scheduleFixedDelay (new RepeatingCommand () {
            public boolean execute () {
                if (check (path)) {
                    carouselPagination (path);
                    return false;
                } else {
                    return true;
                }
            }
        }, 100);
    }


    private static native void carousel (String path)/*-{
		$wnd.jQuery(path).jcarousel({
			wrap : 'circular'
		}).jcarouselAutoscroll({
			interval : 2000,
			autostart : true
		});
    }-*/;


    private static native void carouselControlLeft (String path)/*-{
		$wnd.jQuery(path).jcarouselControl({
			target : '-=1'
		});
    }-*/;


    private static native void carouselControlRight (String path)/*-{        
		$wnd.jQuery(path).jcarouselControl({
			target : '+=1'
		});
    }-*/;


    private static native void carouselPagination (String path)/*-{
		$wnd.jQuery(path).on('jcarouselpagination:active',
				'a', function() {
					$wnd.jQuery(this).addClass('active');
				}).on('jcarouselpagination:inactive', 'a', function() {
			$wnd.jQuery(this).removeClass('active');
		}).jcarouselPagination();
    }-*/;


    private native static boolean check (String path) /*-{
		// return true when all 3party js target elements are available
		return !!$wnd.jQuery(path);
    }-*/;

}
