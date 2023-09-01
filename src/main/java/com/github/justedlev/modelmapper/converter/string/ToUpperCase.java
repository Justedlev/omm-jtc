package com.github.justedlev.modelmapper.converter.string;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

/**
 * The class is implementation of the {@link Converter}&lt;{@link String}, {@link String}&gt;
 * and just will convert the {@link String} to upper case
 * using the {@link String#toUpperCase()} by default
 * the {@link Locale} can be customized if needed,
 * another case will return the null value
 *
 * @author Edward Lukashevits
 * @since 1.0
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ToUpperCase implements Converter<String, String> {
    private Locale locale;

    @Override
    public String convert(MappingContext<String, String> context) {
        return Optional.of(context)
                .map(MappingContext::getSource)
                .map(this::toUpperCase)
                .orElse(null);
    }

    private String toUpperCase(String s) {
        return Objects.isNull(locale) ? s.toUpperCase() : s.toUpperCase(locale);
    }

    /**
     * Will return the new instance
     *
     * @return {@link ToUpperCase}
     */
    public static ToUpperCase getInstance() {
        return getInstance(null);
    }

    /**
     * Will return the new instance with custom {@link Locale}
     *
     * @param locale {@link Locale}
     * @return {@link ToUpperCase}
     */
    public static ToUpperCase getInstance(Locale locale) {
        return new ToUpperCase(locale);
    }
}
