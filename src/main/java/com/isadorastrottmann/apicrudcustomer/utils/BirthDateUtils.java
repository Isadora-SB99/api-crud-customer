package com.isadorastrottmann.apicrudcustomer.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BirthDateUtils {

    public static LocalDateTime mountBirthDate(Integer birthYear, Integer birthMonth, Integer birthDay) {
        return LocalDateTime.of(birthYear, birthMonth, birthDay, 00, 00);
    }

    public static List<Integer> separateBirthDate(LocalDateTime birthDate) {
        return List.of(birthDate.getYear(), birthDate.getMonthValue(), birthDate.getDayOfMonth());
    }

    private static boolean isAgeOver18(LocalDateTime birthDate) {
        long age = birthDate.until(LocalDateTime.now(), ChronoUnit.YEARS);
        return age > 18;
    }

    private static boolean isValidDate(LocalDateTime birthDate) {
        return birthDate.isBefore(LocalDateTime.now());
    }

    public static boolean validateBirthDate(LocalDateTime birthDate) {
        return isAgeOver18(birthDate) && isValidDate(birthDate);
    }
}
