package com.github.justedlev.modelmapper.converter.date;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * The class is implementation of the {@link Converter}&lt;{@link Timestamp}, {@link LocalDateTime}&gt;
 * and just will convert the {@link Timestamp} to the {@link LocalDateTime}
 * using the {@link Timestamp#toLocalDateTime()}
 * if the source not null, another will return the null value
 *
 * @author Edward Lukashevits
 * @since 1.0
 */
public class Timestamp2LocalDateTime implements Converter<Timestamp, LocalDateTime> {
    @Override
    public LocalDateTime convert(MappingContext<Timestamp, LocalDateTime> context) {
        return Optional.of(context)
                .map(MappingContext::getSource)
                .map(Timestamp::toLocalDateTime)
                .orElse(null);
    }

    /**
     * Will return the new instance
     *
     * @return {@link Timestamp2LocalDateTime}
     */
    public static Timestamp2LocalDateTime getInstance() {
        return new Timestamp2LocalDateTime();
    }
}
