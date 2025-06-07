package com.weather.api.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entidade que representa os dados meteorológicos por hora.
 */
@Entity
@Table(name = "hourly_weather_data")
public class HourlyWeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(nullable = false)
    private Long dt;

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

    @Column(nullable = false)
    private Double pop;

    @OneToMany(mappedBy = "hourlyWeatherData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeatherCondition> weatherConditions = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public HourlyWeatherData() {
    }

    /**
     * Construtor com todos os campos.
     */
    public HourlyWeatherData(Long id, Location location, Long dt, Double temp, Double feelsLike,
                            Integer pressure, Integer humidity, Double dewPoint, Double uvi,
                            Integer clouds, Integer visibility, Double windSpeed, Integer windDeg,
                            Double windGust, Double pop, List<WeatherCondition> weatherConditions) {
        this.id = id;
        this.location = location;
        this.dt = dt;
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
        this.pop = pop;
        this.weatherConditions = weatherConditions != null ? weatherConditions : new ArrayList<>();
    }

    /**
     * Adiciona uma condição meteorológica.
     *
     * @param weatherCondition Condição meteorológica
     */
    public void addWeatherCondition(WeatherCondition weatherCondition) {
        weatherConditions.add(weatherCondition);
        weatherCondition.setHourlyWeatherData(this);
    }

    /**
     * Remove uma condição meteorológica.
     *
     * @param weatherCondition Condição meteorológica
     */
    public void removeWeatherCondition(WeatherCondition weatherCondition) {
        weatherConditions.remove(weatherCondition);
        weatherCondition.setHourlyWeatherData(null);
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

    public Double getPop() {
        return pop;
    }

    public void setPop(Double pop) {
        this.pop = pop;
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
        HourlyWeatherData that = (HourlyWeatherData) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "HourlyWeatherData{" +
                "id=" + id +
                ", dt=" + dt +
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
                ", pop=" + pop +
                '}';
    }

    /**
     * Builder para a classe HourlyWeatherData.
     */
    public static class HourlyWeatherDataBuilder {
        private Long id;
        private Location location;
        private Long dt;
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
        private Double pop;
        private List<WeatherCondition> weatherConditions = new ArrayList<>();

        public HourlyWeatherDataBuilder() {
        }

        public HourlyWeatherDataBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public HourlyWeatherDataBuilder location(Location location) {
            this.location = location;
            return this;
        }

        public HourlyWeatherDataBuilder dt(Long dt) {
            this.dt = dt;
            return this;
        }

        public HourlyWeatherDataBuilder temp(Double temp) {
            this.temp = temp;
            return this;
        }

        public HourlyWeatherDataBuilder feelsLike(Double feelsLike) {
            this.feelsLike = feelsLike;
            return this;
        }

        public HourlyWeatherDataBuilder pressure(Integer pressure) {
            this.pressure = pressure;
            return this;
        }

        public HourlyWeatherDataBuilder humidity(Integer humidity) {
            this.humidity = humidity;
            return this;
        }

        public HourlyWeatherDataBuilder dewPoint(Double dewPoint) {
            this.dewPoint = dewPoint;
            return this;
        }

        public HourlyWeatherDataBuilder uvi(Double uvi) {
            this.uvi = uvi;
            return this;
        }

        public HourlyWeatherDataBuilder clouds(Integer clouds) {
            this.clouds = clouds;
            return this;
        }

        public HourlyWeatherDataBuilder visibility(Integer visibility) {
            this.visibility = visibility;
            return this;
        }

        public HourlyWeatherDataBuilder windSpeed(Double windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public HourlyWeatherDataBuilder windDeg(Integer windDeg) {
            this.windDeg = windDeg;
            return this;
        }

        public HourlyWeatherDataBuilder windGust(Double windGust) {
            this.windGust = windGust;
            return this;
        }

        public HourlyWeatherDataBuilder pop(Double pop) {
            this.pop = pop;
            return this;
        }

        public HourlyWeatherDataBuilder weatherConditions(List<WeatherCondition> weatherConditions) {
            this.weatherConditions = weatherConditions;
            return this;
        }

        public HourlyWeatherData build() {
            return new HourlyWeatherData(id, location, dt, temp, feelsLike, pressure, humidity,
                    dewPoint, uvi, clouds, visibility, windSpeed, windDeg, windGust, pop, weatherConditions);
        }
    }

    public static HourlyWeatherDataBuilder builder() {
        return new HourlyWeatherDataBuilder();
    }
}

