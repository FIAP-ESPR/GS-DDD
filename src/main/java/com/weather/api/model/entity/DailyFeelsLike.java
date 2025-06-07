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
 * Entidade que representa a sensação térmica diária.
 */
@Entity
@Table(name = "daily_feels_like")
public class DailyFeelsLike {

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

    /**
     * Construtor padrão.
     */
    public DailyFeelsLike() {
    }

    /**
     * Construtor com todos os campos.
     */
    public DailyFeelsLike(Long id, double morn, double day, double eve, double night) {
        this.id = id;
        this.morn = morn;
        this.day = day;
        this.eve = eve;
        this.night = night;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyFeelsLike that = (DailyFeelsLike) o;
        return Double.compare(that.morn, morn) == 0 &&
                Double.compare(that.day, day) == 0 &&
                Double.compare(that.eve, eve) == 0 &&
                Double.compare(that.night, night) == 0 &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, morn, day, eve, night);
    }

    @Override
    public String toString() {
        return "DailyFeelsLike{" +
                "id=" + id +
                ", morn=" + morn +
                ", day=" + day +
                ", eve=" + eve +
                ", night=" + night +
                "}";
    }

    /**
     * Builder para a classe DailyFeelsLike.
     */
    public static class DailyFeelsLikeBuilder {
        private Long id;
        private double morn;
        private double day;
        private double eve;
        private double night;

        public DailyFeelsLikeBuilder() {
        }

        public DailyFeelsLikeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DailyFeelsLikeBuilder morn(double morn) {
            this.morn = morn;
            return this;
        }

        public DailyFeelsLikeBuilder day(double day) {
            this.day = day;
            return this;
        }

        public DailyFeelsLikeBuilder eve(double eve) {
            this.eve = eve;
            return this;
        }

        public DailyFeelsLikeBuilder night(double night) {
            this.night = night;
            return this;
        }

        public DailyFeelsLike build() {
            return new DailyFeelsLike(id, morn, day, eve, night);
        }
    }

    public static DailyFeelsLikeBuilder builder() {
        return new DailyFeelsLikeBuilder();
    }
}

