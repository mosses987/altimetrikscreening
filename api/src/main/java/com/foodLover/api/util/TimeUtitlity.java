package com.foodLover.api.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Configuration
public class TimeUtitlity {

    @Bean
    public Boolean theTime(){
        Calendar C = new GregorianCalendar();
        int hour = C.get( Calendar.HOUR_OF_DAY );
        int minute = C.get( Calendar.MINUTE );

        if( hour > 14 && hour <18 ) return true;
        return false;
    }
}
