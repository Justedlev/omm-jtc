package com.github.justedlev.modelmapper.converter.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.util.Date;

class DateInstant2TimestampTest {
    static DateInstant2Timestamp dateInstant2Timestamp = DateInstant2Timestamp.getInstance();
    static ModelMapper modelMapper = new ModelMapper();
    Date date = new Date();

    @BeforeAll
    static void beforeAll() {
        modelMapper.addConverter(dateInstant2Timestamp);
    }

    @Test
    void convert() {
        var actual = modelMapper.map(date, Timestamp.class);

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(date.getTime(), actual.getTime());
        Assertions.assertEquals(date.toInstant(), actual.toInstant());
    }
}