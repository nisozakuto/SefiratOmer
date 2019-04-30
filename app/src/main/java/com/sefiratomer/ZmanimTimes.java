package com.sefiratomer;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import zmanim.ComplexZmanimCalendar;
import zmanim.util.GeoLocation;

public class ZmanimTimes {

    String Sunrise(double latitude, double longitude, String geolocation) {
       String locationName = geolocation;
        //double latitude = 41.0082;
        //double longitude = 28.9784;

        //Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"),Locale.getDefault());
        //Date currentLocalTime = calendar.getTime();
        //DateFormat date = new SimpleDateFormat("z", Locale.getDefault());
        //String localTime = date.format(currentLocalTime);
        //Log.i("TimeZone", String.valueOf(localTime));

        double elevation = 0; //optional elevation
        TimeZone timeZone = TimeZone.getDefault();
        Log.i("timezoneTest", String.valueOf(timeZone));
        GeoLocation location = new GeoLocation(locationName, latitude, longitude, elevation, timeZone);
        //GeoLocation location1 = new GeoLocation();

        ComplexZmanimCalendar czc = new ComplexZmanimCalendar(location);

        Date sunrise = czc.getSunrise();;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR), month = calendar.get(Calendar.MONTH), day_of_month = calendar.get(Calendar.DAY_OF_MONTH);
        czc.setCalendar(new GregorianCalendar(year, month, day_of_month));
        Log.i("CZC", " "+czc);
        Log.i("Calendar date", year + "Year/ " + month + "Month/  " + day_of_month+ "Day  ");
        Log.i("Test", "Today's Zmanim for " + sunrise + location);
        Log.i("timezoneTest", String.valueOf(sunrise));

        return String.valueOf(sunrise);
    }

}
