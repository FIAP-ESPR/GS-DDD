package com.weather.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.api.model.entity.Location;
import com.weather.api.model.entity.WeatherAlert;

/**
 * Repositório para a entidade WeatherAlert.
 */
@Repository
public interface WeatherAlertRepository extends JpaRepository<WeatherAlert, Long> {

    /**
     * Busca os alertas meteorológicos de uma localização.
     *
     * @param location Localização
     * @return Lista de alertas meteorológicos
     */
    List<WeatherAlert> findByLocation(Location location);

    /**
     * Busca os alertas meteorológicos pela latitude e longitude da localização.
     *
     * @param latitude  Latitude
     * @param longitude Longitude
     * @return Lista de alertas meteorológicos
     */
    List<WeatherAlert> findByLocationLatitudeAndLocationLongitude(Double latitude, Double longitude);

    /**
     * Busca os alertas meteorológicos ativos de uma localização.
     *
     * @param location  Localização
     * @param timestamp Timestamp Unix atual
     * @return Lista de alertas meteorológicos ativos
     */
    List<WeatherAlert> findByLocationAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
            Location location, Long timestamp, Long timestamp2);

    /**
     * Busca os alertas meteorológicos por evento.
     *
     * @param event Evento
     * @return Lista de alertas meteorológicos
     */
    List<WeatherAlert> findByEvent(String event);
}

