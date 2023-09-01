package com.github.justedlev.modelmapper.converter.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class LocalDate2TimestampTest {
    static LocalDate2Timestamp localDate2Timestamp = LocalDate2Timestamp.getInstance();
    static ModelMapper modelMapper = new ModelMapper();
    LocalDate localDate = LocalDate.now();
    LocalTime localTime = LocalTime.MIN;

    @BeforeAll
    static void beforeAll() {
        modelMapper.addConverter(localDate2Timestamp);
    }

    @BeforeEach
    void setUp() {
        localDate2Timestamp.setTime(localTime);
    }

    @Test
    void convert() {
        var actual = modelMapper.map(localDate, Timestamp.class);

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(LocalDateTime.of(localDate, localTime), actual.toLocalDateTime());
    }

    @Test
    void getTime() {
        var time = localDate2Timestamp.getTime();
        Assertions.assertNotNull(time);
        Assertions.assertEquals(time, localTime);
    }

    @Test
    void setTime() {
        localDate2Timestamp.setTime(LocalTime.MAX);
        Assertions.assertEquals(LocalTime.MAX, localDate2Timestamp.getTime());
    }
}