package com.weather.api.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entidade que representa os dados meteorológicos atuais.
 */
@Entity
@Table(name = "current_weather_data")
public class CurrentWeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(nullable = false)
    private Long dt;

    @Column(nullable = false)
    private Long sunrise;

    @Column(nullable = false)
    private Long sunset;

    @Column(nullable = false)
    private Double temp;

    @Column(name = "feels_like", nullable = false)
    private Double feelsLike;

    @Column(nullable = false)
    private Integer pressure;

    @Column(nullable = false)
    private Integer humidity;

    @Column(name = "dew_point", nullable = false)
    private Double dewPoint;

    @Column(nullable = false)
    private Double uvi;

    @Column(nullable = false)
    private Integer clouds;

    @Column(nullable = false)
    private Integer visibility;

    @Column(name = "wind_speed", nullable = false)
    private Double windSpeed;

    @Column(name = "wind_deg", nullable = false)
    private Integer windDeg;

    @Column(name = "wind_gust")
    private Double windGust;

    @OneToMany(mappedBy = "currentWeatherData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeatherCondition> weatherConditions = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public CurrentWeatherData() {
    }

    /**
     * Construtor com todos os campos.
     */
    public CurrentWeatherData(Long id, Location location, Long dt, Long sunrise, Long sunset, Double temp,
                             Double feelsLike, Integer pressure, Integer humidity, Double dewPoint, Double uvi,
                             Integer clouds, Integer visibility, Double windSpeed, Integer windDeg, Double windGust,
                             List<WeatherCondition> weatherConditions) {
        this.id = id;
        this.location = location;
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dewPoint = dewPoint;
        this.uvi = uvi;
        this.clouds = clouds;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.windGust = windGust;
        this.weatherConditions = weatherConditions != null ? weatherConditions : new ArrayList<>();
    }

    /**
     * Adiciona uma condição meteorológica.
     *
     * @param weatherCondition Condição meteorológica
     */
    public void addWeatherCondition(WeatherCondition weatherCondition) {
        weatherConditions.add(weatherCondition);
        weatherCondition.setCurrentWeatherData(this);
    }

    /**
     * Remove uma condição meteorológica.
     *
     * @param weatherCondition Condição meteorológica
     */
    public void removeWeatherCondition(WeatherCondition weatherCondition) {
        weatherConditions.remove(weatherCondition);
        weatherCondition.setCurrentWeatherData(null);
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

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Double getUvi() {
        return uvi;
    }

    public void setUvi(Double uvi) {
        this.uvi = uvi;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(Integer windDeg) {
        this.windDeg = windDeg;
    }

    public Double getWindGust() {
        return windGust;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    public List<WeatherCondition> getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(List<WeatherCondition> weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentWeatherData that = (CurrentWeatherData) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CurrentWeatherData{" +
                "id=" + id +
                ", dt=" + dt +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", temp=" + temp +
                ", feelsLike=" + feelsLike +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", dewPoint=" + dewPoint +
                ", uvi=" + uvi +
                ", clouds=" + clouds +
                ", visibility=" + visibility +
                ", windSpeed=" + windSpeed +
                ", windDeg=" + windDeg +
                ", windGust=" + windGust +
                '}';
    }

    /**
     * Builder para a classe CurrentWeatherData.
     */
    public static class CurrentWeatherDataBuilder {
        private Long id;
        private Location location;
        private Long dt;
        private Long sunrise;
        private Long sunset;
        private Double temp;
        private Double feelsLike;
        private Integer pressure;
        private Integer humidity;
        private Double dewPoint;
        private Double uvi;
        private Integer clouds;
        private Integer visibility;
        private Double windSpeed;
        private Integer windDeg;
        private Double windGust;
        private List<WeatherCondition> weatherConditions = new ArrayList<>();

        public CurrentWeatherDataBuilder() {
        }

        public CurrentWeatherDataBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CurrentWeatherDataBuilder location(Location location) {
            this.location = location;
            return this;
        }

        public CurrentWeatherDataBuilder dt(Long dt) {
            this.dt = dt;
            return this;
        }

        public CurrentWeatherDataBuilder sunrise(Long sunrise) {
            this.sunrise = sunrise;
            return this;
        }

        public CurrentWeatherDataBuilder sunset(Long sunset) {
            this.sunset = sunset;
            return this;
        }

        public CurrentWeatherDataBuilder temp(Double temp) {
            this.temp = temp;
            return this;
        }

        public CurrentWeatherDataBuilder feelsLike(Double feelsLike) {
            this.feelsLike = feelsLike;
            return this;
        }

        public CurrentWeatherDataBuilder pressure(Integer pressure) {
            this.pressure = pressure;
            return this;
        }

        public CurrentWeatherDataBuilder humidity(Integer humidity) {
            this.humidity = humidity;
            return this;
        }

        public CurrentWeatherDataBuilder dewPoint(Double dewPoint) {
            this.dewPoint = dewPoint;
            return this;
        }

        public CurrentWeatherDataBuilder uvi(Double uvi) {
            this.uvi = uvi;
            return this;
        }

        public CurrentWeatherDataBuilder clouds(Integer clouds) {
            this.clouds = clouds;
            return this;
        }

        public CurrentWeatherDataBuilder visibility(Integer visibility) {
            this.visibility = visibility;
            return this;
        }

        public CurrentWeatherDataBuilder windSpeed(Double windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public CurrentWeatherDataBuilder windDeg(Integer windDeg) {
            this.windDeg = windDeg;
            return this;
        }

        public CurrentWeatherDataBuilder windGust(Double windGust) {
            this.windGust = windGust;
            return this;
        }

        public CurrentWeatherDataBuilder weatherConditions(List<WeatherCondition> weatherConditions) {
            this.weatherConditions = weatherConditions;
            return this;
        }

        public CurrentWeatherData build() {
            return new CurrentWeatherData(id, location, dt, sunrise, sunset, temp, feelsLike, pressure,
                    humidity, dewPoint, uvi, clouds, visibility, windSpeed, windDeg, windGust, weatherConditions);
        }
    }

    public static CurrentWeatherDataBuilder builder() {
        return new CurrentWeatherDataBuilder();
    }
}

