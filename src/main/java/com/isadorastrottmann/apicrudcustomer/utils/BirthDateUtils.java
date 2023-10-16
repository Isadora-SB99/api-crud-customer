package com.isadorastrottmann.apicrudcustomer.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BirthDateUtils {

    public static LocalDateTime mountBirthDate(Integer birthYear, Integer birthMonth, Integer birthDay){
        return LocalDateTime.of(birthYear, birthMonth, birthDay, 00, 00);
    }

    public static List<Integer> separateBirthDate(LocalDateTime birthDate){
        return List.of(birthDate.getYear(), birthDate.getMonthValue(), birthDate.getDayOfMonth());
    }

    public static boolean isValidBirthDate(LocalDateTime birthDate){
        long age = birthDate.until(LocalDateTime.now(), ChronoUnit.YEARS);
        boolean isValidAge = age > 18;

        boolean isBeforToday = birthDate.isBefore(LocalDateTime.now());

        return isValidAge && isBeforToday;
    }
}
