package com.github.justedlev.modelmapper.converter.date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

/**
 * The class is implementation of the {@link Converter}&lt;{@link LocalDate}, {@link Timestamp}&gt;
 * and just will convert the {@link LocalDate} to the {@link Timestamp},
 * by default time is {@link LocalTime#MIN},
 * if the source not null, another will return the null value
 *
 * @author Edward Lukashevits
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalDate2Timestamp implements Converter<LocalDate, Timestamp> {
    private LocalTime time;

    @Override
    public Timestamp convert(MappingContext<LocalDate, Timestamp> context) {
        return Optional.of(context)
                .map(MappingContext::getSource)
                .map(current -> LocalDateTime.of(current, time))
                .map(Timestamp::valueOf)
                .orElse(null);
    }

    /**
     * Will return the new instance with the {@link LocalTime#MIN} by default
     *
     * @return {@link LocalDate2Timestamp}
     */
    public static LocalDate2Timestamp getInstance() {
        return getInstance(LocalTime.MIN);
    }

    /**
     * Will return the new instance with the custom {@link LocalTime}
     *
     * @param time {@link LocalTime}
     * @return {@link LocalDate2Timestamp}
     */
    public static LocalDate2Timestamp getInstance(LocalTime time) {
        return new LocalDate2Timestamp(time);
    }
}
