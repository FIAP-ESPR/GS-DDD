/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.factory;

import com.weather.api.model.dto.*;
import com.weather.api.model.entity.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Fábrica para criar DTOs de dados meteorológicos a partir de entidades.
 */
public class WeatherDTOFactory {

    private WeatherDTOFactory() {
        // Construtor privado para evitar instanciação
    }

    public static WeatherDataDTO createWeatherDataDTO(CurrentWeatherData current, List<MinutelyWeatherData> minutely,
                                                      List<HourlyWeatherData> hourly, List<DailyWeatherData> daily,
                                                      List<WeatherAlert> alerts) {
        return WeatherDataDTO.builder()
                .current(createCurrentWeatherDTO(current))
                .minutely(minutely != null ? minutely.stream().map(WeatherDTOFactory::createMinutelyWeatherDTO).collect(Collectors.toList()) : null)
                .hourly(hourly != null ? hourly.stream().map(WeatherDTOFactory::createHourlyWeatherDTO).collect(Collectors.toList()) : null)
                .daily(daily != null ? daily.stream().map(WeatherDTOFactory::createDailyWeatherDTO).collect(Collectors.toList()) : null)
                .alerts(alerts != null ? alerts.stream().map(WeatherDTOFactory::createWeatherAlertDTO).collect(Collectors.toList()) : null)
                .build();
    }

    public static CurrentWeatherDTO createCurrentWeatherDTO(CurrentWeatherData current) {
        if (current == null) {
            return null;
        }
        return CurrentWeatherDTO.builder()
                .dt(current.getDt())
                .sunrise(current.getSunrise())
                .sunset(current.getSunset())
                .temp(current.getTemp())
                .feels_like(current.getFeelsLike())
                .pressure(current.getPressure())
                .humidity(current.getHumidity())
                .dew_point(current.getDewPoint())
                .uvi(current.getUvi())
                .clouds(current.getClouds())
                .visibility(current.getVisibility())
                .wind_speed(current.getWindSpeed())
                .wind_deg(current.getWindDeg())
                .wind_gust(current.getWindGust())
                .weather(current.getWeatherConditions() != null ? current.getWeatherConditions().stream().map(WeatherDTOFactory::createWeatherConditionDTO).collect(Collectors.toList()) : null)
                .build();
    }

    public static MinutelyWeatherDTO createMinutelyWeatherDTO(MinutelyWeatherData minutely) {
        if (minutely == null) {
            return null;
        }
        return MinutelyWeatherDTO.builder()
                .dt(minutely.getDt())
                .precipitation(minutely.getPrecipitation())
                .build();
    }

    public static HourlyWeatherDTO createHourlyWeatherDTO(HourlyWeatherData hourly) {
        if (hourly == null) {
            return null;
        }
        return HourlyWeatherDTO.builder()
                .dt(hourly.getDt())
                .temp(hourly.getTemp())
                .feels_like(hourly.getFeelsLike())
                .pressure(hourly.getPressure())
                .humidity(hourly.getHumidity())
                .dew_point(hourly.getDewPoint())
                .uvi(hourly.getUvi())
                .clouds(hourly.getClouds())
                .visibility(hourly.getVisibility())
                .wind_speed(hourly.getWindSpeed())
                .wind_deg(hourly.getWindDeg())
                .wind_gust(hourly.getWindGust())
                .weather(hourly.getWeatherConditions() != null ? hourly.getWeatherConditions().stream().map(WeatherDTOFactory::createWeatherConditionDTO).collect(Collectors.toList()) : null)
                .pop(hourly.getPop())
                .build();
    }

    public static DailyWeatherDTO createDailyWeatherDTO(DailyWeatherData daily) {
        if (daily == null) {
            return null;
        }
        return DailyWeatherDTO.builder()
                .dt(daily.getDt())
                .sunrise(daily.getSunrise())
                .sunset(daily.getSunset())
                .moonrise(daily.getMoonrise())
                .moonset(daily.getMoonset())
                .moon_phase(daily.getMoonPhase())
                .summary(daily.getSummary())
                .temp(createDailyTemperatureDTO(daily.getTemp())) 
                .feels_like(createDailyFeelsLikeDTO(daily.getFeelsLike())) 
                .pressure(daily.getPressure())
                .humidity(daily.getHumidity())
                .dew_point(daily.getDewPoint())
                .wind_speed(daily.getWindSpeed())
                .wind_deg(daily.getWindDeg())
                .wind_gust(daily.getWindGust())
                .clouds(daily.getClouds())
                .pop(daily.getPop())
                .rain(daily.getRain())
                .uvi(daily.getUvi())
                .weather(daily.getWeatherConditions() != null ? daily.getWeatherConditions().stream().map(WeatherDTOFactory::createWeatherConditionDTO).collect(Collectors.toList()) : null)
                .build();
    }

    public static DailyTemperatureDTO createDailyTemperatureDTO(DailyTemperature temp) {
        if (temp == null) {
            return null;
        }
        return DailyTemperatureDTO.builder()
                .day(temp.getDay())
                .min(temp.getMin())
                .max(temp.getMax())
                .night(temp.getNight())
                .eve(temp.getEve())
                .morn(temp.getMorn())
                .build();
    }

    public static DailyFeelsLikeDTO createDailyFeelsLikeDTO(DailyFeelsLike feelsLike) {
        if (feelsLike == null) {
            return null;
        }
        return DailyFeelsLikeDTO.builder()
                .day(feelsLike.getDay())
                .night(feelsLike.getNight())
                .eve(feelsLike.getEve())
                .morn(feelsLike.getMorn())
                .build();
    }

    public static WeatherConditionDTO createWeatherConditionDTO(WeatherCondition condition) {
        if (condition == null) {
            return null;
        }
        return WeatherConditionDTO.builder()
                .id(condition.getConditionId())
                .main(condition.getMain())
                .description(condition.getDescription())
                .icon(condition.getIcon())
                .build();
    }

    public static WeatherAlertDTO createWeatherAlertDTO(WeatherAlert alert) {
        if (alert == null) {
            return null;
        }
        return WeatherAlertDTO.builder()
                .sender_name(alert.getSenderName())
                .event(alert.getEvent())
                .start_time(alert.getStartTime())
                .end_time(alert.getEndTime())
                .description(alert.getDescription())
                .tags(alert.getTags())
                .build();
    }
}

