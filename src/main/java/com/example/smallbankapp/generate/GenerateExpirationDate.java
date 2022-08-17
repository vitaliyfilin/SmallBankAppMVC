package com.example.smallbankapp.generate;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GenerateExpirationDate {
    public static Date generateExpirationDate() {
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 5);
        Date nextYear = cal.getTime();
        return nextYear;
    }
}

