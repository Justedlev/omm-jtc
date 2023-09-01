package com.github.justedlev.modelmapper.converter.number;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * The class is implementation of the {@link Converter}&lt;{@link BigDecimal}, {@link Long}&gt;
 * and just will convert the {@link LocalDateTime} to the {@link Timestamp}
 * using the {@link BigDecimal#longValue()}
 * if the source not null, another will return the null value
 *
 * @author Edward Lukashevits
 * @since 1.0
 */
public class BigDecimal2Long implements Converter<BigDecimal, Long> {
    @Override
    public Long convert(MappingContext<BigDecimal, Long> context) {
        return Optional.of(context)
                .map(MappingContext::getSource)
                .map(BigDecimal::longValue)
                .orElse(null);
    }

    /**
     * Will return the new instance
     *
     * @return {@link BigDecimal2Long}
     */
    public static BigDecimal2Long getInstance() {
        return new BigDecimal2Long();
    }
}
