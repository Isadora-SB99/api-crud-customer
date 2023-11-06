package com.isadorastrottmann.apicrudcustomer.utils;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BirthDateUtilsTest {

    @Test
    void shouldReturnBirthDate() {
        var expected = LocalDateTime.of(1999,9,23,0,0);

        int year = 1999;
        int month = 9;
        int day = 23;
        var response = BirthDateUtils.mountBirthDate(year, month, day);

        assertEquals(expected, response);
    }

    @Test
    void shouldReturnListOfInts() {
        var expected = List.of(1999,9,23);

        var birthDate = LocalDateTime.of(1999,9,23,0,0);
        var response = BirthDateUtils.separateBirthDate(birthDate);

        assertEquals(expected, response);
    }

    @Test
    void shouldReturnTrueForValidBirthDate() {
        var birthDate = LocalDateTime.of(1999,9,23,0,0);

        assertTrue(BirthDateUtils.validateBirthDate(birthDate));
    }

    @Test
    void shouldReturnFalseForUnder18() {
        var birthDate = LocalDateTime.now();

        assertFalse(BirthDateUtils.validateBirthDate(birthDate));
    }

    @Test
    void shouldReturnFalseForAfterToday() {
        var birthDate = LocalDateTime.now().plusDays(2);

        assertFalse(BirthDateUtils.validateBirthDate(birthDate));

    }
}