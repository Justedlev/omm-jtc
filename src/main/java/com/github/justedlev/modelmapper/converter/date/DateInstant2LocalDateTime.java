package com.github.justedlev.modelmapper.converter.date;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

/**
 * The class is implementation of the {@link Converter}&lt;{@link Date}, {@link LocalDateTime}&gt;
 * and just will convert the {@link Instant} using the {@link Date#toInstant()} method,
 * to the {@link LocalDateTime} using the {@link Timestamp#from(Instant)} method
 * if the source not null, another will return the null value
 *
 * @author Edward Lukashevits
 * @since 1.0
 */
@RequiredArgsConstructor
public class DateInstant2LocalDateTime implements Converter<Date, LocalDateTime> {
    private final ZoneId zoneId;

    @Override
    public LocalDateTime convert(MappingContext<Date, LocalDateTime> mappingContext) {
        return Optional.of(mappingContext)
                .map(MappingContext::getSource)
                .map(Date::toInstant)
                .map(instant -> LocalDateTime.ofInstant(instant, zoneId))
                .orElse(null);
    }

    /**
     * Will return the new instance with the {@link ZoneId#systemDefault()} by default
     *
     * @return {@link DateInstant2LocalDateTime}
     */
    public static DateInstant2LocalDateTime getInstance() {
        return new DateInstant2LocalDateTime(ZoneId.systemDefault());
    }
}
