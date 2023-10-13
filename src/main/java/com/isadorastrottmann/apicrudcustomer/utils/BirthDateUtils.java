package com.isadorastrottmann.apicrudcustomer.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BirthDateUtils {

    public LocalDateTime mountBirthDate(Integer birthYear, Integer birthMonth, Integer birthDay){
        return LocalDateTime.of(birthYear, birthMonth, birthDay, 00, 00);
    }

    public boolean isValidBirthDate(LocalDateTime birthDate){
        long age = birthDate.until(LocalDateTime.now(), ChronoUnit.YEARS);
        boolean isValidAge = age > 18;

//        boolean isAfterToday = birthDate.isAfter(LocalDateTime.now());
        boolean isBeforToday = birthDate.isBefore(LocalDateTime.now());

        return isValidAge && isBeforToday;
    }
}
