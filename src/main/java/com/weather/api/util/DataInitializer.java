/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.util;

import com.weather.api.model.entity.*;
import com.weather.api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collections;

/**
 * Classe para inicializar dados de exemplo no banco de dados.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final WeatherService weatherService;

    @Autowired
    public DataInitializer(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Dados de exemplo para localização
        Location saoPaulo = Location.builder()
                .latitude(-23.5505)
                .longitude(-46.6333)
                .cityName("São Paulo")
                .stateCode("SP")
                .countryCode("Brasil")
                .timezone("America/Sao_Paulo")
                .timezoneOffset(-10800) // -3 horas em segundos
                .build();
        weatherService.saveLocation(saoPaulo);

        // Dados de exemplo para CurrentWeatherData
        CurrentWeatherData currentSaoPaulo = CurrentWeatherData.builder()
                .location(saoPaulo)
                .dt(Instant.now().getEpochSecond())
                .sunrise(Instant.now().getEpochSecond() - 3600)
                .sunset(Instant.now().getEpochSecond() + 3600)
                .temp(25.5)
                .feelsLike(26.0)
                .pressure(1012)
                .humidity(70)
                .dewPoint(19.0)
                .uvi(7.5)
                .clouds(40)
                .visibility(10000)
                .windSpeed(5.2)
                .windDeg(270)
                .windGust(7.0)
                .weatherConditions(Collections.singletonList(WeatherCondition.builder()
                        .conditionId(800)
                        .main("Clear")
                        .description("céu limpo")
                        .icon("01d")
                        .build()))
                .build();
        weatherService.saveCurrentWeatherData(currentSaoPaulo);

        // Dados de exemplo para MinutelyWeatherData
        MinutelyWeatherData minutelySaoPaulo = MinutelyWeatherData.builder()
                .location(saoPaulo)
                .dt(Instant.now().getEpochSecond())
                .precipitation(0.0)
                .build();
        weatherService.saveMinutelyWeatherData(minutelySaoPaulo);

        // Dados de exemplo para HourlyWeatherData
        HourlyWeatherData hourlySaoPaulo = HourlyWeatherData.builder()
                .location(saoPaulo)
                .dt(Instant.now().getEpochSecond())
                .temp(24.0)
                .feelsLike(25.0)
                .pressure(1011)
                .humidity(75)
                .dewPoint(18.5)
                .uvi(6.0)
                .clouds(50)
                .visibility(9000)
                .windSpeed(6.0)
                .windDeg(280)
                .windGust(8.0)
                .weatherConditions(Collections.singletonList(WeatherCondition.builder()
                        .conditionId(801)
                        .main("Clouds")
                        .description("nuvens dispersas")
                        .icon("02d")
                        .build()))
                .pop(0.1)
                .build();
        weatherService.saveHourlyWeatherData(hourlySaoPaulo);

        // Dados de exemplo para DailyWeatherData
        DailyWeatherData dailySaoPaulo = DailyWeatherData.builder()
                .location(saoPaulo)
                .dt(Instant.now().getEpochSecond())
                .sunrise(Instant.now().getEpochSecond() - 3600)
                .sunset(Instant.now().getEpochSecond() + 3600)
                .moonrise(Instant.now().getEpochSecond() - 7200)
                .moonset(Instant.now().getEpochSecond() + 7200)
                .moonPhase(0.5)
                .summary("Dia ensolarado com algumas nuvens.")
                .temp(DailyTemperature.builder()
                        .morn(20.0)
                        .day(28.0)
                        .eve(22.0)
                        .night(18.0)
                        .min(18.0)
                        .max(28.0)
                        .build())
                .feelsLike(DailyFeelsLike.builder()
                        .morn(21.0)
                        .day(29.0)
                        .eve(23.0)
                        .night(19.0)
                        .build())
                .pressure(1010)
                .humidity(65)
                .dewPoint(17.0)
                .windSpeed(4.5)
                .windDeg(260)
                .windGust(6.5)
                .clouds(30)
                .pop(0.0)
                .rain(0.0)
                .uvi(8.0)
                .weatherConditions(Collections.singletonList(WeatherCondition.builder()
                        .conditionId(800)
                        .main("Clear")
                        .description("céu limpo")
                        .icon("01d")
                        .build()))
                .build();
        weatherService.saveDailyWeatherData(dailySaoPaulo);

        // Dados de exemplo para WeatherAlert
        WeatherAlert alertSaoPaulo = WeatherAlert.builder()
                .location(saoPaulo)
                .senderName("Defesa Civil")
                .event("Chuva Forte")
                .startTime(Instant.now().getEpochSecond() + 1800)
                .endTime(Instant.now().getEpochSecond() + 7200)
                .description("Previsão de chuva forte com possibilidade de alagamentos.")
                .tags(Arrays.asList("chuva", "alagamento", "alerta"))
                .build();
        weatherService.saveWeatherAlert(alertSaoPaulo);
    }
}

