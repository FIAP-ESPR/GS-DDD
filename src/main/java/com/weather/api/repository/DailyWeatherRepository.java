package com.weather.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.api.model.entity.DailyWeatherData;
import com.weather.api.model.entity.Location;

/**
 * Repositório para a entidade DailyWeatherData.
 */
@Repository
public interface DailyWeatherRepository extends JpaRepository<DailyWeatherData, Long> {

    /**
     * Busca os dados meteorológicos diários de uma localização.
     *
     * @param location Localização
     * @return Lista de dados meteorológicos diários
     */
    List<DailyWeatherData> findByLocation(Location location);

    /**
     * Busca os dados meteorológicos diários de uma localização, ordenados por timestamp.
     *
     * @param location Localização
     * @return Lista de dados meteorológicos diários
     */
    List<DailyWeatherData> findByLocationOrderByDtAsc(Location location);

    /**
     * Busca os dados meteorológicos diários pela latitude e longitude da localização.
     *
     * @param latitude  Latitude
     * @param longitude Longitude
     * @return Lista de dados meteorológicos diários
     */
    List<DailyWeatherData> findByLocationLatitudeAndLocationLongitude(Double latitude, Double longitude);

    /**
     * Busca os dados meteorológicos diários de uma localização, dentro de um intervalo de tempo.
     *
     * @param location Localização
     * @param startDt  Timestamp Unix de início
     * @param endDt    Timestamp Unix de fim
     * @return Lista de dados meteorológicos diários
     */
    List<DailyWeatherData> findByLocationAndDtBetweenOrderByDtAsc(Location location, Long startDt, Long endDt);
}

