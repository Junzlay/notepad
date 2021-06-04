/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 2ndyrGroupB
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author 2ndyrGroupB
 */
public class Date {
    
    public String getTime(){
//        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        java.util.Date date = Calendar.getInstance().getTime();
DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
String strDate = dateFormat.format(date);

        return strDate;
    }

    @Override
    public String toString() {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
        String strDate = formatter.format(date);
        return strDate.toString();
    }
}