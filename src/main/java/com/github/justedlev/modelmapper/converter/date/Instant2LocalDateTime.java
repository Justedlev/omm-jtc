package com.github.justedlev.modelmapper.converter.date;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

/**
 * The class is implementation of the {@link Converter}&lt;{@link Instant}, {@link LocalDateTime}&gt;
 * and just will convert the {@link Instant}
 * to the {@link LocalDateTime} using the {@link LocalDateTime#ofInstant(Instant, ZoneId)} method
 * if the source not null, another will return the null value
 *
 * @author Edward Lukashevits
 * @since 1.0
 */
@RequiredArgsConstructor
public class Instant2LocalDateTime implements Converter<Instant, LocalDateTime> {
    private final ZoneId zoneId;

    @Override
    public LocalDateTime convert(MappingContext<Instant, LocalDateTime> mappingContext) {
        return Optional.of(mappingContext)
                .map(MappingContext::getSource)
                .map(instant -> LocalDateTime.ofInstant(instant, zoneId))
                .orElse(null);
    }

    /**
     * Will return the new instance with the {@link ZoneId#systemDefault()} by default
     *
     * @return {@link Instant2LocalDateTime}
     */
    public static Instant2LocalDateTime getInstance() {
        return new Instant2LocalDateTime(ZoneId.systemDefault());
    }
}
