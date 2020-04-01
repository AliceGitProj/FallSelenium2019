package com.automation.utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtilities {

    /**
     * This method returns current date as a string
     * Provide a format as a parameter
     *
     * MM-to specify month like: 01, 02, 03
     * MMM- to specify month: Jan, Feb, Mar
     * dd- to specify day: 01, 02, 03
     * yyyy - to specify year : 2010, 2020
     *
     * @param format for example MMM dd, yyyy = Mar 29, 2020
     * @return current date as a String
     */

    public static String getCurrentDate(String format) {

        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    /**
     * This mee\thos returns difference between end and start time
     * @param start
     * @param end
     * @param format like h:m a--5:15 AM
     * @return difference between end time and start time as a long
     */
    public static long getTimeDifference(String start, String end, String format){
        LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern(format));
        LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern(format));
        return ChronoUnit.HOURS.between(startTime,endTime);
    }
}
