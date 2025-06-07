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
 * DTO que representa a temperatura diária.
 */
public class DailyTemperatureDTO {

    private double day;
    private double min;
    private double max;
    private double night;
    private double eve;
    private double morn;

    /**
     * Construtor padrão.
     */
    public DailyTemperatureDTO() {
    }

    /**
     * Construtor com todos os campos.
     */
    public DailyTemperatureDTO(double day, double min, double max, double night, double eve, double morn) {
        this.day = day;
        this.min = min;
        this.max = max;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
    }

    // Getters e Setters

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyTemperatureDTO that = (DailyTemperatureDTO) o;
        return Double.compare(that.day, day) == 0 &&
                Double.compare(that.min, min) == 0 &&
                Double.compare(that.max, max) == 0 &&
                Double.compare(that.night, night) == 0 &&
                Double.compare(that.eve, eve) == 0 &&
                Double.compare(that.morn, morn) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, min, max, night, eve, morn);
    }

    @Override
    public String toString() {
        return "DailyTemperatureDTO{" +
                "day=" + day +
                ", min=" + min +
                ", max=" + max +
                ", night=" + night +
                ", eve=" + eve +
                ", morn=" + morn +
                "}";
    }

    /**
     * Builder para a classe DailyTemperatureDTO.
     */
    public static class DailyTemperatureDTOBuilder {
        private double day;
        private double min;
        private double max;
        private double night;
        private double eve;
        private double morn;

        public DailyTemperatureDTOBuilder() {
        }

        public DailyTemperatureDTOBuilder day(double day) {
            this.day = day;
            return this;
        }

        public DailyTemperatureDTOBuilder min(double min) {
            this.min = min;
            return this;
        }

        public DailyTemperatureDTOBuilder max(double max) {
            this.max = max;
            return this;
        }

        public DailyTemperatureDTOBuilder night(double night) {
            this.night = night;
            return this;
        }

        public DailyTemperatureDTOBuilder eve(double eve) {
            this.eve = eve;
            return this;
        }

        public DailyTemperatureDTOBuilder morn(double morn) {
            this.morn = morn;
            return this;
        }

        public DailyTemperatureDTO build() {
            return new DailyTemperatureDTO(day, min, max, night, eve, morn);
        }
    }

    public static DailyTemperatureDTOBuilder builder() {
        return new DailyTemperatureDTOBuilder();
    }
}

