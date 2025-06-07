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
 * DTO que representa a sensação térmica diária.
 */
public class DailyFeelsLikeDTO {

    private double day;
    private double night;
    private double eve;
    private double morn;

    /**
     * Construtor padrão.
     */
    public DailyFeelsLikeDTO() {
    }

    /**
     * Construtor com todos os campos.
     */
    public DailyFeelsLikeDTO(double day, double night, double eve, double morn) {
        this.day = day;
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
        DailyFeelsLikeDTO that = (DailyFeelsLikeDTO) o;
        return Double.compare(that.day, day) == 0 &&
                Double.compare(that.night, night) == 0 &&
                Double.compare(that.eve, eve) == 0 &&
                Double.compare(that.morn, morn) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, night, eve, morn);
    }

    @Override
    public String toString() {
        return "DailyFeelsLikeDTO{" +
                "day=" + day +
                ", night=" + night +
                ", eve=" + eve +
                ", morn=" + morn +
                "}";
    }

    /**
     * Builder para a classe DailyFeelsLikeDTO.
     */
    public static class DailyFeelsLikeDTOBuilder {
        private double day;
        private double night;
        private double eve;
        private double morn;

        public DailyFeelsLikeDTOBuilder() {
        }

        public DailyFeelsLikeDTOBuilder day(double day) {
            this.day = day;
            return this;
        }

        public DailyFeelsLikeDTOBuilder night(double night) {
            this.night = night;
            return this;
        }

        public DailyFeelsLikeDTOBuilder eve(double eve) {
            this.eve = eve;
            return this;
        }

        public DailyFeelsLikeDTOBuilder morn(double morn) {
            this.morn = morn;
            return this;
        }

        public DailyFeelsLikeDTO build() {
            return new DailyFeelsLikeDTO(day, night, eve, morn);
        }
    }

    public static DailyFeelsLikeDTOBuilder builder() {
        return new DailyFeelsLikeDTOBuilder();
    }
}

