/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entidade que representa os dados meteorológicos diários.
 */
@Entity
@Table(name = "daily_weather_data")
public class DailyWeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(nullable = false)
    private Long dt;

    @Column(nullable = false)
    private Long sunrise;

    @Column(nullable = false)
    private Long sunset;

    @Column(nullable = false)
    private Long moonrise;

    @Column(nullable = false)
    private Long moonset;

    @Column(name = "moon_phase", nullable = false)
    private Double moonPhase;

    @Column(nullable = false)
    private String summary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "temp_id", referencedColumnName = "id")
    private DailyTemperature temp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feels_like_id", referencedColumnName = "id")
    private DailyFeelsLike feelsLike;

    @Column(nullable = false)
    private Integer pressure;

    @Column(nullable = false)
    private Integer humidity;

    @Column(name = "dew_point", nullable = false)
    private Double dewPoint;

    @Column(name = "wind_speed", nullable = false)
    private Double windSpeed;

    @Column(name = "wind_deg", nullable = false)
    private Integer windDeg;

    @Column(name = "wind_gust", nullable = false)
    private Double windGust;

    @Column(nullable = false)
    private Integer clouds;

    @Column(nullable = false)
    private Double pop;

    @Column(nullable = false)
    private Double rain;

    @Column(nullable = false)
    private Double uvi;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "daily_weather_data_id")
    private List<WeatherCondition> weatherConditions = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public DailyWeatherData() {
    }

    /**
     * Construtor com todos os campos.
     */
    public DailyWeatherData(Long id, Location location, Long dt, Long sunrise, Long sunset, Long moonrise,
                            Long moonset, Double moonPhase, String summary, DailyTemperature temp,
                            DailyFeelsLike feelsLike, Integer pressure, Integer humidity, Double dewPoint,
                            Double windSpeed, Integer windDeg, Double windGust, Integer clouds, Double pop,
                            Double rain, Double uvi, List<WeatherCondition> weatherConditions) {
        this.id = id;
        this.location = location;
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
        this.moonPhase = moonPhase;
        this.summary = summary;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dewPoint = dewPoint;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.windGust = windGust;
        this.clouds = clouds;
        this.pop = pop;
        this.rain = rain;
        this.uvi = uvi;
        this.weatherConditions = weatherConditions != null ? weatherConditions : new ArrayList<>();
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

    public Long getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(Long moonrise) {
        this.moonrise = moonrise;
    }

    public Long getMoonset() {
        return moonset;
    }

    public void setMoonset(Long moonset) {
        this.moonset = moonset;
    }

    public Double getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(Double moonPhase) {
        this.moonPhase = moonPhase;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public DailyTemperature getTemp() {
        return temp;
    }

    public void setTemp(DailyTemperature temp) {
        this.temp = temp;
    }

    public DailyFeelsLike getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(DailyFeelsLike feelsLike) {
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

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public Double getPop() {
        return pop;
    }

    public void setPop(Double pop) {
        this.pop = pop;
    }

    public Double getRain() {
        return rain;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    public Double getUvi() {
        return uvi;
    }

    public void setUvi(Double uvi) {
        this.uvi = uvi;
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
        DailyWeatherData that = (DailyWeatherData) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DailyWeatherData{" +
                "id=" + id +
                ", dt=" + dt +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", moonPhase=" + moonPhase +
                ", summary=\"" + summary + "\"" +
                ", temp=" + temp +
                ", feelsLike=" + feelsLike +
                "}";
    }

    /**
     * Builder para a classe DailyWeatherData.
     */
    public static class DailyWeatherDataBuilder {
        private Long id;
        private Location location;
        private Long dt;
        private Long sunrise;
        private Long sunset;
        private Long moonrise;
        private Long moonset;
        private Double moonPhase;
        private String summary;
        private DailyTemperature temp;
        private DailyFeelsLike feelsLike;
        private Integer pressure;
        private Integer humidity;
        private Double dewPoint;
        private Double windSpeed;
        private Integer windDeg;
        private Double windGust;
        private Integer clouds;
        private Double pop;
        private Double rain;
        private Double uvi;
        private List<WeatherCondition> weatherConditions = new ArrayList<>();

        public DailyWeatherDataBuilder() {
        }

        public DailyWeatherDataBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DailyWeatherDataBuilder location(Location location) {
            this.location = location;
            return this;
        }

        public DailyWeatherDataBuilder dt(Long dt) {
            this.dt = dt;
            return this;
        }

        public DailyWeatherDataBuilder sunrise(Long sunrise) {
            this.sunrise = sunrise;
            return this;
        }

        public DailyWeatherDataBuilder sunset(Long sunset) {
            this.sunset = sunset;
            return this;
        }

        public DailyWeatherDataBuilder moonrise(Long moonrise) {
            this.moonrise = moonrise;
            return this;
        }

        public DailyWeatherDataBuilder moonset(Long moonset) {
            this.moonset = moonset;
            return this;
        }

        public DailyWeatherDataBuilder moonPhase(Double moonPhase) {
            this.moonPhase = moonPhase;
            return this;
        }

        public DailyWeatherDataBuilder summary(String summary) {
            this.summary = summary;
            return this;
        }

        public DailyWeatherDataBuilder temp(DailyTemperature temp) {
            this.temp = temp;
            return this;
        }

        public DailyWeatherDataBuilder feelsLike(DailyFeelsLike feelsLike) {
            this.feelsLike = feelsLike;
            return this;
        }

        public DailyWeatherDataBuilder pressure(Integer pressure) {
            this.pressure = pressure;
            return this;
        }

        public DailyWeatherDataBuilder humidity(Integer humidity) {
            this.humidity = humidity;
            return this;
        }

        public DailyWeatherDataBuilder dewPoint(Double dewPoint) {
            this.dewPoint = dewPoint;
            return this;
        }

        public DailyWeatherDataBuilder windSpeed(Double windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public DailyWeatherDataBuilder windDeg(Integer windDeg) {
            this.windDeg = windDeg;
            return this;
        }

        public DailyWeatherDataBuilder windGust(Double windGust) {
            this.windGust = windGust;
            return this;
        }

        public DailyWeatherDataBuilder clouds(Integer clouds) {
            this.clouds = clouds;
            return this;
        }

        public DailyWeatherDataBuilder pop(Double pop) {
            this.pop = pop;
            return this;
        }

        public DailyWeatherDataBuilder rain(Double rain) {
            this.rain = rain;
            return this;
        }

        public DailyWeatherDataBuilder uvi(Double uvi) {
            this.uvi = uvi;
            return this;
        }

        public DailyWeatherDataBuilder weatherConditions(List<WeatherCondition> weatherConditions) {
            this.weatherConditions = weatherConditions;
            return this;
        }

        public DailyWeatherData build() {
            return new DailyWeatherData(id, location, dt, sunrise, sunset, moonrise, moonset, moonPhase, summary, temp,
                    feelsLike, pressure, humidity, dewPoint, windSpeed, windDeg, windGust, clouds, pop, rain, uvi, weatherConditions);
        }
    }

    public static DailyWeatherDataBuilder builder() {
        return new DailyWeatherDataBuilder();
    }
}

