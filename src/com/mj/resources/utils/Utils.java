
package com.mj.resources.utils;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.i18n.client.TimeZone;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class Utils {

    public static void setId (IsWidget w, String id) {
        w.asWidget ().getElement ().setId ("sdp_" + id);
    }


    public static void marginTop (IsWidget w, int margin) {
        DOM.setStyleAttribute (w.asWidget ().getElement (), "marginTop", margin + "px");
    }


    public static void marginLeft (IsWidget w, int margin) {
        DOM.setStyleAttribute (w.asWidget ().getElement (), "marginLeft", margin + "px");
    }


    public static void marginRight (IsWidget w, int margin) {
        DOM.setStyleAttribute (w.asWidget ().getElement (), "marginRight", margin + "px");
    }


    public static void margins (IsWidget w, int top, int right, int bottom, int left) {
        DOM.setStyleAttribute (w.asWidget ().getElement (), "margin", top + "px " + right + "px "
                + bottom + "px " + left + "px ");
    }


    public static void margins (IsWidget w, int margin) {
        DOM.setStyleAttribute (w.asWidget ().getElement (), "margin", margin + "px");
    }


    public static void paddings (IsWidget w, int padding) {
        DOM.setStyleAttribute (w.asWidget ().getElement (), "padding", padding + "px");
    }


    public static void paddings (IsWidget w, int top, int right, int bottom, int left) {
        DOM.setStyleAttribute (w.asWidget ().getElement (), "padding", top + "px " + right + "px "
                + bottom + "px " + left + "px ");
    }


    public static void style (IsWidget w, String name, String value) {
        DOM.setStyleAttribute (w.asWidget ().getElement (), name, value);
    }


    public static void alignLeft (HasAlignment widget) {
        widget.setHorizontalAlignment (HasAlignment.ALIGN_LEFT);
    }


    public static void alignRight (HasAlignment widget) {
        widget.setHorizontalAlignment (HasAlignment.ALIGN_RIGHT);
    }


    public static void alignCenter (HasAlignment widget) {
        widget.setHorizontalAlignment (HasAlignment.ALIGN_CENTER);
    }


    public static void alignLeft (CellPanel table, Widget w) {
        table.setCellHorizontalAlignment (w, HasAlignment.ALIGN_LEFT);
    }


    public static void alignRight (CellPanel table, Widget w) {
        table.setCellHorizontalAlignment (w, HasAlignment.ALIGN_RIGHT);
    }


    public static void alignCenter (CellPanel table, Widget w) {
        table.setCellHorizontalAlignment (w, HasAlignment.ALIGN_CENTER);
    }


    public static void alignMiddle (CellPanel table, Widget w) {
        table.setCellVerticalAlignment (w, HasAlignment.ALIGN_MIDDLE);
    }


    public static void alignTop (CellPanel table, Widget w) {
        table.setCellVerticalAlignment (w, HasAlignment.ALIGN_TOP);
    }


    public static void alignBottom (CellPanel table, Widget w) {
        table.setCellVerticalAlignment (w, HasAlignment.ALIGN_BOTTOM);
    }


    public static void floatLeft (IsWidget w) {
        Utils.style (w, "cssFloat", "left");
        Utils.style (w, "styleFloat", "left"); // IE
    }


    public static void floatRight (IsWidget w) {
        Utils.style (w, "cssFloat", "right");
        Utils.style (w, "styleFloat", "right"); // IE
    }


    public static void clearBoth (IsWidget w) {
        Utils.style (w, "clear", "both");
    }


    public static void alignLeft (FlexTable table, int row, int col) {
        table.getFlexCellFormatter ().setHorizontalAlignment (row, col, HasAlignment.ALIGN_LEFT);
    }


    public static void alignRight (FlexTable table, int row, int col) {
        table.getFlexCellFormatter ().setHorizontalAlignment (row, col, HasAlignment.ALIGN_RIGHT);
    }


    public static void alignCenter (FlexTable table, int row, int col) {
        table.getFlexCellFormatter ().setHorizontalAlignment (row, col, HasAlignment.ALIGN_CENTER);
    }


    public static void alignMiddle (FlexTable table, int row, int col) {
        table.getFlexCellFormatter ().setVerticalAlignment (row, col, HasAlignment.ALIGN_MIDDLE);
    }


    public static void alignTop (FlexTable table, int row, int col) {
        table.getFlexCellFormatter ().setVerticalAlignment (row, col, HasAlignment.ALIGN_TOP);
    }


    public static void alignBottom (FlexTable table, int row, int col) {
        table.getFlexCellFormatter ().setVerticalAlignment (row, col, HasAlignment.ALIGN_BOTTOM);
    }


    @SuppressWarnings ("deprecation")
    public static String getNMonthAgoShortName (int i) {
        // GWT CalendarUtils is bugged
        String[] months = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
                "Sept", "Oct", "Nov", "Dec" };

        Date date = new Date ();
        int month = date.getMonth ();

        if (month - i < 0) {
            return months[month + 12 - i];
        } else {
            return months[month - i];
        }

    }


    public static String getNMonthAgoName (int i) {

        String[] months = new String[] { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };

        Date date = new Date ();
        @SuppressWarnings ("deprecation")
        int month = date.getMonth ();

        if (month - i < 0) {
            return months[month + 12 - i];
        } else {
            return months[month - i];
        }
    }


    public static boolean isLessThanHours (String startDate, String endDate, int hour) {

        DateTimeFormat dateFormat = DateTimeFormat.getFormat (PredefinedFormat.DATE_TIME_FULL);

        Date dateFrom = dateFormat.parse (startDate);

        Date dateTo = dateFormat.parse (endDate);

        long diffMilliseconds = dateFrom.getTime () - dateTo.getTime ();

        long diffHours = diffMilliseconds / (1000 * 60 * 60);

        if (diffHours <= hour) {
            return true;
        }

        return false;
    }


    /**
     * Get UTC time in GWT client side
     * 
     * @param date to be parsed
     * @return UTC date
     */
    public static Date getUTCTime (Date date) {

        DateTimeFormat dtf = DateTimeFormat.getFormat ("yyyyMMddHHmmss");

        TimeZone utc = TimeZone.createTimeZone (0);

        return dtf.parse (dtf.format (date, utc));

    }


    public static boolean isEmpty (String s) {
        if (s == null || s.isEmpty ()) {
            return true;
        } else {
            return false;
        }
    }


    public static String ensureNotNull (Object s) {
        if (s != null)
            return s.toString ();
        return "";
    }

}
