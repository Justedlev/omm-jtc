package com.github.justedlev.modelmapper.converter.number;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * The class is implementation of the {@link Converter}&lt;{@link BigDecimal}, {@link Double}&gt;
 * and just will convert the {@link BigDecimal} to the {@link Double}
 * using the {@link BigDecimal#doubleValue()}
 * if the source not null, another will return the null value
 *
 * @author Edward Lukashevits
 * @since 1.0
 */
public class BigDecimal2Double implements Converter<BigDecimal, Double> {
    @Override
    public Double convert(MappingContext<BigDecimal, Double> context) {
        return Optional.of(context)
                .map(MappingContext::getSource)
                .map(BigDecimal::doubleValue)
                .orElse(null);
    }

    /**
     * Will return the new instance
     *
     * @return {@link BigDecimal2Double}
     */
    public static BigDecimal2Double getInstance() {
        return new BigDecimal2Double();
    }
}
