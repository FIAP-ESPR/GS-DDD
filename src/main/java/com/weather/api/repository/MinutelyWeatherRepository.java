/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.repository;

import com.weather.api.model.entity.MinutelyWeatherData;
import com.weather.api.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para a entidade MinutelyWeatherData.
 */
@Repository
public interface MinutelyWeatherRepository extends JpaRepository<MinutelyWeatherData, Long> {

    /**
     * Encontra dados meteorológicos por minuto para uma localização específica.
     *
     * @param location A localização.
     * @return Uma lista de dados meteorológicos por minuto para a localização.
     */
    List<MinutelyWeatherData> findByLocation(Location location);
}

