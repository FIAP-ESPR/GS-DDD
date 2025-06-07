/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.model.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidade que representa os dados meteorológicos por minuto.
 */
@Entity
@Table(name = "minutely_weather_data")
public class MinutelyWeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(nullable = false)
    private Long dt;

    @Column(nullable = false)
    private Double precipitation;

    /**
     * Construtor padrão.
     */
    public MinutelyWeatherData() {
    }

    /**
     * Construtor com todos os campos.
     */
    public MinutelyWeatherData(Long id, Location location, Long dt, Double precipitation) {
        this.id = id;
        this.location = location;
        this.dt = dt;
        this.precipitation = precipitation;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinutelyWeatherData that = (MinutelyWeatherData) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MinutelyWeatherData{" +
                "id=" + id +
                ", dt=" + dt +
                ", precipitation=" + precipitation +
                "}";
    }

    /**
     * Builder para a classe MinutelyWeatherData.
     */
    public static class MinutelyWeatherDataBuilder {
        private Long id;
        private Location location;
        private Long dt;
        private Double precipitation;

        public MinutelyWeatherDataBuilder() {
        }

        public MinutelyWeatherDataBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MinutelyWeatherDataBuilder location(Location location) {
            this.location = location;
            return this;
        }

        public MinutelyWeatherDataBuilder dt(Long dt) {
            this.dt = dt;
            return this;
        }

        public MinutelyWeatherDataBuilder precipitation(Double precipitation) {
            this.precipitation = precipitation;
            return this;
        }

        public MinutelyWeatherData build() {
            return new MinutelyWeatherData(id, location, dt, precipitation);
        }
    }

    public static MinutelyWeatherDataBuilder builder() {
        return new MinutelyWeatherDataBuilder();
    }
}

