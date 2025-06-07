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
 * Entidade que representa uma condição meteorológica.
 */
@Entity
@Table(name = "weather_conditions")
public class WeatherCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "condition_id", nullable = false)
    private Integer conditionId;

    @Column(nullable = false)
    private String main;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String icon;

    @ManyToOne
    @JoinColumn(name = "current_weather_id")
    private CurrentWeatherData currentWeatherData;

    @ManyToOne
    @JoinColumn(name = "hourly_weather_id")
    private HourlyWeatherData hourlyWeatherData;

    @ManyToOne
    @JoinColumn(name = "daily_weather_id")
    private DailyWeatherData dailyWeatherData;

    /**
     * Construtor padrão.
     */
    public WeatherCondition() {
    }

    /**
     * Construtor com todos os campos.
     */
    public WeatherCondition(Long id, Integer conditionId, String main, String description, String icon,
                           CurrentWeatherData currentWeatherData, HourlyWeatherData hourlyWeatherData,
                           DailyWeatherData dailyWeatherData) {
        this.id = id;
        this.conditionId = conditionId;
        this.main = main;
        this.description = description;
        this.icon = icon;
        this.currentWeatherData = currentWeatherData;
        this.hourlyWeatherData = hourlyWeatherData;
        this.dailyWeatherData = dailyWeatherData;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public CurrentWeatherData getCurrentWeatherData() {
        return currentWeatherData;
    }

    public void setCurrentWeatherData(CurrentWeatherData currentWeatherData) {
        this.currentWeatherData = currentWeatherData;
    }

    public HourlyWeatherData getHourlyWeatherData() {
        return hourlyWeatherData;
    }

    public void setHourlyWeatherData(HourlyWeatherData hourlyWeatherData) {
        this.hourlyWeatherData = hourlyWeatherData;
    }

    public DailyWeatherData getDailyWeatherData() {
        return dailyWeatherData;
    }

    public void setDailyWeatherData(DailyWeatherData dailyWeatherData) {
        this.dailyWeatherData = dailyWeatherData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherCondition that = (WeatherCondition) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WeatherCondition{" +
                "id=" + id +
                ", conditionId=" + conditionId +
                ", main=\"" + main + "\"" +
                ", description=\"" + description + "\"" +
                ", icon=\"" + icon + "\"" +
                "}";
    }

    /**
     * Builder para a classe WeatherCondition.
     */
    public static class WeatherConditionBuilder {
        private Long id;
        private Integer conditionId;
        private String main;
        private String description;
        private String icon;
        private CurrentWeatherData currentWeatherData;
        private HourlyWeatherData hourlyWeatherData;
        private DailyWeatherData dailyWeatherData;

        public WeatherConditionBuilder() {
        }

        public WeatherConditionBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public WeatherConditionBuilder conditionId(Integer conditionId) {
            this.conditionId = conditionId;
            return this;
        }

        public WeatherConditionBuilder main(String main) {
            this.main = main;
            return this;
        }

        public WeatherConditionBuilder description(String description) {
            this.description = description;
            return this;
        }

        public WeatherConditionBuilder icon(String icon) {
            this.icon = icon;
            return this;
        }

        public WeatherConditionBuilder currentWeatherData(CurrentWeatherData currentWeatherData) {
            this.currentWeatherData = currentWeatherData;
            return this;
        }

        public WeatherConditionBuilder hourlyWeatherData(HourlyWeatherData hourlyWeatherData) {
            this.hourlyWeatherData = hourlyWeatherData;
            return this;
        }

        public WeatherConditionBuilder dailyWeatherData(DailyWeatherData dailyWeatherData) {
            this.dailyWeatherData = dailyWeatherData;
            return this;
        }

        public WeatherCondition build() {
            return new WeatherCondition(id, conditionId, main, description, icon,
                    currentWeatherData, hourlyWeatherData, dailyWeatherData);
        }
    }

    public static WeatherConditionBuilder builder() {
        return new WeatherConditionBuilder();
    }
}

