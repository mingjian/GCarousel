package com.mj.gwt.carousel.frwk;

public class GCarousel {

    public static void renderById (String id) {
        carousel ("#" + id);
    }


    public static void renderByCSS (String css) {
        carousel ("." + css);
    }


    public static void controlLeft (String css) {
        carouselControlLeft ("." + css);
    }


    public static void controlRight (String css) {
        carouselControlRight ("." + css);
    }


    public static void pagination () {
        carouselPagination ();
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


    private static native void carouselPagination ()/*-{
		$wnd.jQuery('.jcarousel-pagination').on('jcarouselpagination:active',
				'a', function() {
					$wnd.jQuery(this).addClass('active');
				}).on('jcarouselpagination:inactive', 'a', function() {
			$wnd.jQuery(this).removeClass('active');
		}).jcarouselPagination();
    }-*/;

}
