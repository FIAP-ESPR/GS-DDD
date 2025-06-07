/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.service;

import com.weather.api.model.dto.*;
import com.weather.api.model.entity.*;

import java.util.List;

/**
 * Interface para o serviço de dados meteorológicos.
 */
public interface WeatherService {

    /**
     * Obtém todos os dados meteorológicos para uma localização específica.
     *
     * @param lat Latitude da localização.
     * @param lon Longitude da localização.
     * @return Objeto WeatherDataDTO contendo todos os dados meteorológicos.
     */
    WeatherDataDTO getWeatherData(Double lat, Double lon);

    /**
     * Obtém os dados meteorológicos atuais para uma localização específica.
     *
     * @param lat Latitude da localização.
     * @param lon Longitude da localização.
     * @return Objeto CurrentWeatherDTO contendo os dados meteorológicos atuais.
     */
    CurrentWeatherDTO getCurrentWeather(Double lat, Double lon);

    /**
     * Obtém os dados meteorológicos por minuto para uma localização específica.
     *
     * @param lat Latitude da localização.
     * @param lon Longitude da localização.
     * @return Lista de MinutelyWeatherDTO contendo os dados meteorológicos por minuto.
     */
    List<MinutelyWeatherDTO> getMinutelyWeather(Double lat, Double lon);

    /**
     * Obtém os dados meteorológicos por hora para uma localização específica.
     *
     * @param lat Latitude da localização.
     * @param lon Longitude da localização.
     * @return Lista de HourlyWeatherDTO contendo os dados meteorológicos por hora.
     */
    List<HourlyWeatherDTO> getHourlyWeather(Double lat, Double lon);

    /**
     * Obtém os dados meteorológicos diários para uma localização específica.
     *
     * @param lat Latitude da localização.
     * @param lon Longitude da localização.
     * @return Lista de DailyWeatherDTO contendo os dados meteorológicos diários.
     */
    List<DailyWeatherDTO> getDailyWeather(Double lat, Double lon);

    /**
     * Obtém os alertas meteorológicos para uma localização específica.
     *
     * @param lat Latitude da localização.
     * @param lon Longitude da localização.
     * @return Lista de WeatherAlertDTO contendo os alertas meteorológicos.
     */
    List<WeatherAlertDTO> getWeatherAlerts(Double lat, Double lon);

    /**
     * Salva uma localização.
     *
     * @param location A localização a ser salva.
     */
    void saveLocation(Location location);

    /**
     * Salva os dados meteorológicos atuais.
     *
     * @param currentWeatherData Os dados meteorológicos atuais a serem salvos.
     */
    void saveCurrentWeatherData(CurrentWeatherData currentWeatherData);

    /**
     * Salva os dados meteorológicos por minuto.
     *
     * @param minutelyWeatherData Os dados meteorológicos por minuto a serem salvos.
     */
    void saveMinutelyWeatherData(MinutelyWeatherData minutelyWeatherData);

    /**
     * Salva os dados meteorológicos por hora.
     *
     * @param hourlyWeatherData Os dados meteorológicos por hora a serem salvos.
     */
    void saveHourlyWeatherData(HourlyWeatherData hourlyWeatherData);

    /**
     * Salva os dados meteorológicos diários.
     *
     * @param dailyWeatherData Os dados meteorológicos diários a serem salvos.
     */
    void saveDailyWeatherData(DailyWeatherData dailyWeatherData);

    /**
     * Salva um alerta meteorológico.
     *
     * @param weatherAlert O alerta meteorológico a ser salvo.
     */
    void saveWeatherAlert(WeatherAlert weatherAlert);

    /**
     * Atualiza os dados meteorológicos para uma localização específica.
     *
     * @param lat Latitude da localização.
     * @param lon Longitude da localização.
     * @param weatherDataDTO Os dados meteorológicos atualizados.
     */
    void updateWeatherData(Double lat, Double lon, WeatherDataDTO weatherDataDTO);
}

