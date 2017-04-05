package com.alexkbit.iblog.rest.converters;

import org.dozer.DozerConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Converter for date
 */
public class DateConverter extends DozerConverter<Date, String> {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public DateConverter() {
        super(Date.class, String.class);
    }

    @Override
    public String convertTo(Date date, String s) {
        return dateFormat.format(date);
    }

    @Override
    public Date convertFrom(String s, Date date) {
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
