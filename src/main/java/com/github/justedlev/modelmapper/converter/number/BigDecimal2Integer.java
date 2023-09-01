package com.github.justedlev.modelmapper.converter.number;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * The class is implementation of the {@link Converter}&lt;{@link BigDecimal}, {@link Integer}&gt;
 * and just will convert the {@link LocalDateTime} to the {@link Timestamp}
 * using the {@link BigDecimal#intValue()}
 * if the source not null, another will return the null value
 *
 * @author Edward Lukashevits
 * @since 1.0
 */
public class BigDecimal2Integer implements Converter<BigDecimal, Integer> {
    @Override
    public Integer convert(MappingContext<BigDecimal, Integer> context) {
        return Optional.of(context)
                .map(MappingContext::getSource)
                .map(BigDecimal::intValue)
                .orElse(null);
    }

    /**
     * Will return the new instance
     *
     * @return {@link BigDecimal2Integer}
     */
    public static BigDecimal2Integer getInstance() {
        return new BigDecimal2Integer();
    }
}
