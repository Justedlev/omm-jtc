package com.github.justedlev.modelmapper.converter.date;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * The class is implementation of the {@link Converter}&lt;{@link Timestamp}, {@link LocalDate}&gt;
 * and just will convert the {@link Timestamp} to the {@link LocalDate}
 * using the {@link Timestamp#toLocalDateTime()} and {@link LocalDateTime#toLocalDate()}
 * if the source not null, another will return the null value
 *
 * @author Edward Lukashevits
 * @since 1.0
 */
public class Timestamp2LocalDate implements Converter<Timestamp, LocalDate> {
    @Override
    public LocalDate convert(MappingContext<Timestamp, LocalDate> context) {
        return Optional.of(context)
                .map(MappingContext::getSource)
                .map(Timestamp::toLocalDateTime)
                .map(LocalDateTime::toLocalDate)
                .orElse(null);
    }

    /**
     * Will return the new instance
     *
     * @return {@link Timestamp2LocalDate}
     */
    public static Timestamp2LocalDate getInstance() {
        return new Timestamp2LocalDate();
    }
}
