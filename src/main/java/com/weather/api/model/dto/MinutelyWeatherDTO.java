/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.model.dto;

import java.util.Objects;

/**
 * DTO que representa os dados meteorológicos por minuto.
 */
public class MinutelyWeatherDTO {

    private long dt;
    private double precipitation;

    /**
     * Construtor padrão.
     */
    public MinutelyWeatherDTO() {
    }

    /**
     * Construtor com todos os campos.
     */
    public MinutelyWeatherDTO(long dt, double precipitation) {
        this.dt = dt;
        this.precipitation = precipitation;
    }

    // Getters e Setters

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinutelyWeatherDTO that = (MinutelyWeatherDTO) o;
        return dt == that.dt &&
                Double.compare(that.precipitation, precipitation) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dt, precipitation);
    }

    @Override
    public String toString() {
        return "MinutelyWeatherDTO{" +
                "dt=" + dt +
                ", precipitation=" + precipitation +
                "}";
    }

    /**
     * Builder para a classe MinutelyWeatherDTO.
     */
    public static class MinutelyWeatherDTOBuilder {
        private long dt;
        private double precipitation;

        public MinutelyWeatherDTOBuilder() {
        }

        public MinutelyWeatherDTOBuilder dt(long dt) {
            this.dt = dt;
            return this;
        }

        public MinutelyWeatherDTOBuilder precipitation(double precipitation) {
            this.precipitation = precipitation;
            return this;
        }

        public MinutelyWeatherDTO build() {
            return new MinutelyWeatherDTO(dt, precipitation);
        }
    }

    public static MinutelyWeatherDTOBuilder builder() {
        return new MinutelyWeatherDTOBuilder();
    }
}

