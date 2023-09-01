package com.github.justedlev.modelmapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

import java.util.Objects;
import java.util.Set;

/**
 * @author Edward Lukashevits
 * @see BaseModelMapper#BaseModelMapper()
 * @since 1.0
 */
public class BaseModelMapper extends ModelMapper {
    /**
     * No args constructor using the {@link ModelMapper#getConfiguration()}:
     * <p>1. {@code setMatchingStrategy(MatchingStrategies.STRICT)}
     * {@link org.modelmapper.config.Configuration#setMatchingStrategy(MatchingStrategy)}
     * <p>2. {@code setSkipNullEnabled(true)}
     * {@link org.modelmapper.config.Configuration#setSkipNullEnabled(boolean)}
     */
    public BaseModelMapper() {
        getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true);
    }

    @Override
    public <D> D map(Object source, Class<D> destination) {
        return Objects.isNull(source) ? null : super.map(source, destination);
    }

    /**
     * Will add the set of {@link Converter} to the {@link ModelMapper} context
     * using the {@link BaseModelMapper#addConverters(Set)}
     *
     * @param converters {@link Converter}
     * @throws NullPointerException if any from the list converters is null
     */
    public void addConverters(Converter<?, ?>... converters) {
        addConverters(Set.of(converters));
    }

    /**
     * Will add the set of {@link Converter} to the {@link ModelMapper} context
     * using the {@link ModelMapper#addConverter(Converter)}
     *
     * @param converters {@link Set}&lt;{@link Converter}&gt;
     * @throws NullPointerException if any from the {@link Set} is null
     */
    public void addConverters(Set<? extends Converter<?, ?>> converters) {
        converters.forEach(super::addConverter);
    }
}
