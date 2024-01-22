package com.SpringBootAnnotations;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component(value = "Logger")
public class Logger {
    public void currentTime() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        System.out.printf("Current Date: %02d/%02d/%d %02d:%02d:%d", day, month, year, hour, minutes, seconds);
        System.out.println();
    }
}
