package com.github.justedlev.modelmapper.converter.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

class LocalDateTime2TimestampTest {
    static LocalDateTime2Timestamp localDateTime2Timestamp = LocalDateTime2Timestamp.getInstance();
    static ModelMapper modelMapper = new ModelMapper();
    LocalDateTime dateTime = LocalDateTime.now();

    @BeforeAll
    static void beforeAll() {
        modelMapper.addConverter(localDateTime2Timestamp);
    }

    @Test
    void convert() {
        var actual = modelMapper.map(dateTime, Timestamp.class);

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(dateTime, actual.toLocalDateTime());
    }
}