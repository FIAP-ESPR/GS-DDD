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
import javax.persistence.Table;

/**
 * Entidade que representa a temperatura diária.
 */
@Entity
@Table(name = "daily_temperatures")
public class DailyTemperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double morn;

    @Column(nullable = false)
    private double day;

    @Column(nullable = false)
    private double eve;

    @Column(nullable = false)
    private double night;

    @Column(nullable = false)
    private double min;

    @Column(nullable = false)
    private double max;

    /**
     * Construtor padrão.
     */
    public DailyTemperature() {
    }

    /**
     * Construtor com todos os campos.
     */
    public DailyTemperature(Long id, double morn, double day, double eve, double night, double min, double max) {
        this.id = id;
        this.morn = morn;
        this.day = day;
        this.eve = eve;
        this.night = night;
        this.min = min;
        this.max = max;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyTemperature that = (DailyTemperature) o;
        return Double.compare(that.morn, morn) == 0 &&
                Double.compare(that.day, day) == 0 &&
                Double.compare(that.eve, eve) == 0 &&
                Double.compare(that.night, night) == 0 &&
                Double.compare(that.min, min) == 0 &&
                Double.compare(that.max, max) == 0 &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, morn, day, eve, night, min, max);
    }

    @Override
    public String toString() {
        return "DailyTemperature{" +
                "id=" + id +
                ", morn=" + morn +
                ", day=" + day +
                ", eve=" + eve +
                ", night=" + night +
                ", min=" + min +
                ", max=" + max +
                "}";
    }

    /**
     * Builder para a classe DailyTemperature.
     */
    public static class DailyTemperatureBuilder {
        private Long id;
        private double morn;
        private double day;
        private double eve;
        private double night;
        private double min;
        private double max;

        public DailyTemperatureBuilder() {
        }

        public DailyTemperatureBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DailyTemperatureBuilder morn(double morn) {
            this.morn = morn;
            return this;
        }

        public DailyTemperatureBuilder day(double day) {
            this.day = day;
            return this;
        }

        public DailyTemperatureBuilder eve(double eve) {
            this.eve = eve;
            return this;
        }

        public DailyTemperatureBuilder night(double night) {
            this.night = night;
            return this;
        }

        public DailyTemperatureBuilder min(double min) {
            this.min = min;
            return this;
        }

        public DailyTemperatureBuilder max(double max) {
            this.max = max;
            return this;
        }

        public DailyTemperature build() {
            return new DailyTemperature(id, morn, day, eve, night, min, max);
        }
    }

    public static DailyTemperatureBuilder builder() {
        return new DailyTemperatureBuilder();
    }
}

