package com.weather.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.api.model.entity.HourlyWeatherData;
import com.weather.api.model.entity.Location;

/**
 * Repositório para a entidade HourlyWeatherData.
 */
@Repository
public interface HourlyWeatherRepository extends JpaRepository<HourlyWeatherData, Long> {

    /**
     * Busca os dados meteorológicos por hora de uma localização.
     *
     * @param location Localização
     * @return Lista de dados meteorológicos por hora
     */
    List<HourlyWeatherData> findByLocation(Location location);

    /**
     * Busca os dados meteorológicos por hora de uma localização, ordenados por timestamp.
     *
     * @param location Localização
     * @return Lista de dados meteorológicos por hora
     */
    List<HourlyWeatherData> findByLocationOrderByDtAsc(Location location);

    /**
     * Busca os dados meteorológicos por hora pela latitude e longitude da localização.
     *
     * @param latitude  Latitude
     * @param longitude Longitude
     * @return Lista de dados meteorológicos por hora
     */
    List<HourlyWeatherData> findByLocationLatitudeAndLocationLongitude(Double latitude, Double longitude);

    /**
     * Busca os dados meteorológicos por hora de uma localização, dentro de um intervalo de tempo.
     *
     * @param location Localização
     * @param startDt  Timestamp Unix de início
     * @param endDt    Timestamp Unix de fim
     * @return Lista de dados meteorológicos por hora
     */
    List<HourlyWeatherData> findByLocationAndDtBetweenOrderByDtAsc(Location location, Long startDt, Long endDt);
}

