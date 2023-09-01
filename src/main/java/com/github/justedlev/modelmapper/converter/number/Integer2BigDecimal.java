package com.github.justedlev.modelmapper.converter.number;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * The class is implementation of the {@link Converter}&lt;{@link Integer}, {@link BigDecimal}&gt;
 * and just will convert the {@link Integer} to the {@link BigDecimal}
 * using the {@link BigDecimal#valueOf(long)}
 * if the source not null, another will return the null value
 *
 * @author Edward Lukashevits
 * @since 1.0
 */
public class Integer2BigDecimal implements Converter<Integer, BigDecimal> {
    @Override
    public BigDecimal convert(MappingContext<Integer, BigDecimal> context) {
        return Optional.of(context)
                .map(MappingContext::getSource)
                .map(BigDecimal::valueOf)
                .orElse(null);
    }

    /**
     * Will return the new instance
     *
     * @return {@link Integer2BigDecimal}
     */
    public static Integer2BigDecimal getInstance() {
        return new Integer2BigDecimal();
    }
}
