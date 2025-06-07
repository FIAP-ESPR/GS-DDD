package com.weather.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.api.model.entity.CurrentWeatherData;
import com.weather.api.model.entity.Location;

/**
 * Repositório para a entidade CurrentWeatherData.
 */
@Repository
public interface CurrentWeatherRepository extends JpaRepository<CurrentWeatherData, Long> {

    /**
     * Busca os dados meteorológicos atuais de uma localização.
     *
     * @param location Localização
     * @return Dados meteorológicos atuais encontrados (opcional)
     */
    Optional<CurrentWeatherData> findByLocation(Location location);

    /**
     * Busca os dados meteorológicos atuais pela latitude e longitude da localização.
     *
     * @param latitude  Latitude
     * @param longitude Longitude
     * @return Dados meteorológicos atuais encontrados (opcional)
     */
    Optional<CurrentWeatherData> findByLocationLatitudeAndLocationLongitude(Double latitude, Double longitude);
}

