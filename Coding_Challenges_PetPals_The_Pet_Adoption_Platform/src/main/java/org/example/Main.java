package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2025-04-09 14:30:00";
        Date parsedDate = sdf.parse(dateString); // converts to java.util.Date

        System.out.println(sdf.format(parsedDate));
    }
}