/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.repository;

import com.weather.api.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para a entidade Location.
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    /**
     * Encontra uma localização pelo nome.
     *
     * @param name O nome da localização.
     * @return A localização encontrada ou null se não existir.
     */
    Location findByName(String name);

    /**
     * Encontra uma localização pela latitude e longitude.
     *
     * @param latitude A latitude da localização.
     * @param longitude A longitude da localização.
     * @return A localização encontrada ou null se não existir.
     */
    Location findByLatitudeAndLongitude(Double latitude, Double longitude);

    /**
     * Encontra todas as localizações.
     *
     * @return Uma lista de todas as localizações.
     */
    List<Location> findAll();
}

