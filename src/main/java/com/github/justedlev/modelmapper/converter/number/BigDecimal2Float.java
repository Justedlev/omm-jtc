package com.github.justedlev.modelmapper.converter.number;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * The class is implementation of the {@link Converter}&lt;{@link BigDecimal}, {@link Float}&gt;
 * and just will convert the {@link BigDecimal} to the {@link Float}
 * using the {@link BigDecimal#floatValue()}
 * if the source not null, another will return the null value
 *
 * @author Edward Lukashevits
 * @since 1.0
 */
public class BigDecimal2Float implements Converter<BigDecimal, Float> {
    @Override
    public Float convert(MappingContext<BigDecimal, Float> context) {
        return Optional.of(context)
                .map(MappingContext::getSource)
                .map(BigDecimal::floatValue)
                .orElse(null);
    }

    /**
     * Will return the new instance
     *
     * @return {@link BigDecimal2Float}
     */
    public static BigDecimal2Float getInstance() {
        return new BigDecimal2Float();
    }
}
