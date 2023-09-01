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
 * and just will convert the {@link String} to lower case
 * using the {@link String#toLowerCase()} by default
 * the {@link Locale} can be customized if needed,
 * another case will return the null value
 *
 * @author Edward Lukashevits
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToLowerCase implements Converter<String, String> {
    private Locale locale;

    @Override
    public String convert(MappingContext<String, String> context) {
        return Optional.of(context)
                .map(MappingContext::getSource)
                .map(this::toLowerCase)
                .orElse(null);
    }

    private String toLowerCase(String s) {
        return Objects.isNull(locale) ? s.toLowerCase() : s.toLowerCase(locale);
    }

    /**
     * Will return the new instance
     *
     * @return {@link ToLowerCase}
     */
    public static ToLowerCase getInstance() {
        return getInstance(null);
    }

    /**
     * Will return the new instance with custom {@link Locale}
     *
     * @param locale {@link Locale}
     * @return {@link ToLowerCase}
     */
    public static ToLowerCase getInstance(Locale locale) {
        return new ToLowerCase(locale);
    }
}
