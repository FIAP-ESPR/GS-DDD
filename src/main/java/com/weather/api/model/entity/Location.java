/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entidade que representa uma localização geográfica.
 */
@Entity
@Table(name = "locations", indexes = {
    @Index(name = "idx_location_lat_lon", columnList = "latitude,longitude", unique = true)
})
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq")
    @SequenceGenerator(name = "location_seq", sequenceName = "LOCATIONS_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private String cityName;

    @Column(nullable = false)
    private String stateCode;

    @Column(nullable = false)
    private String countryCode;

    @Column(nullable = false)
    private String timezone;

    @Column(name = "timezone_offset", nullable = false)
    private Integer timezoneOffset;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private CurrentWeatherData currentWeather;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MinutelyWeatherData> minutelyWeather = new ArrayList<>();

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HourlyWeatherData> hourlyWeather = new ArrayList<>();

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DailyWeatherData> dailyWeather = new ArrayList<>();

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeatherAlert> alerts = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public Location() {
    }

    /**
     * Construtor com todos os campos.
     */
    public Location(Long id, Double latitude, Double longitude, String cityName, String stateCode, String countryCode, String timezone, Integer timezoneOffset,
                   LocalDateTime lastUpdated, CurrentWeatherData currentWeather,
                   List<MinutelyWeatherData> minutelyWeather, List<HourlyWeatherData> hourlyWeather,
                   List<DailyWeatherData> dailyWeather, List<WeatherAlert> alerts) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cityName = cityName;
        this.stateCode = stateCode;
        this.countryCode = countryCode;
        this.timezone = timezone;
        this.timezoneOffset = timezoneOffset;
        this.lastUpdated = lastUpdated;
        this.currentWeather = currentWeather;
        this.minutelyWeather = minutelyWeather != null ? minutelyWeather : new ArrayList<>();
        this.hourlyWeather = hourlyWeather != null ? hourlyWeather : new ArrayList<>();
        this.dailyWeather = dailyWeather != null ? dailyWeather : new ArrayList<>();
        this.alerts = alerts != null ? alerts : new ArrayList<>();
    }

    /**
     * Atualiza a data da última atualização.
     */
    @PreUpdate
    @PrePersist
    public void updateLastUpdated() {
        this.lastUpdated = LocalDateTime.now();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(Integer timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public CurrentWeatherData getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeatherData currentWeather) {
        this.currentWeather = currentWeather;
    }

    public List<MinutelyWeatherData> getMinutelyWeather() {
        return minutelyWeather;
    }

    public void setMinutelyWeather(List<MinutelyWeatherData> minutelyWeather) {
        this.minutelyWeather = minutelyWeather;
    }

    public List<HourlyWeatherData> getHourlyWeather() {
        return hourlyWeather;
    }

    public void setHourlyWeather(List<HourlyWeatherData> hourlyWeather) {
        this.hourlyWeather = hourlyWeather;
    }

    public List<DailyWeatherData> getDailyWeather() {
        return dailyWeather;
    }

    public void setDailyWeather(List<DailyWeatherData> dailyWeather) {
        this.dailyWeather = dailyWeather;
    }

    public List<WeatherAlert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<WeatherAlert> alerts) {
        this.alerts = alerts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", cityName=\"" + cityName + "\"" +
                ", stateCode=\"" + stateCode + "\"" +
                ", countryCode=\"" + countryCode + "\"" +
                ", timezone=\"" + timezone + "\"" +
                ", timezoneOffset=" + timezoneOffset +
                ", lastUpdated=" + lastUpdated +
                "}";
    }

    /**
     * Builder para a classe Location.
     */
    public static class LocationBuilder {
        private Long id;
        private Double latitude;
        private Double longitude;
        private String cityName;
        private String stateCode;
        private String countryCode;
        private String timezone;
        private Integer timezoneOffset;
        private LocalDateTime lastUpdated;
        private CurrentWeatherData currentWeather;
        private List<MinutelyWeatherData> minutelyWeather = new ArrayList<>();
        private List<HourlyWeatherData> hourlyWeather = new ArrayList<>();
        private List<DailyWeatherData> dailyWeather = new ArrayList<>();
        private List<WeatherAlert> alerts = new ArrayList<>();

        public LocationBuilder() {
        }

        public LocationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public LocationBuilder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public LocationBuilder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public LocationBuilder cityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public LocationBuilder stateCode(String stateCode) {
            this.stateCode = stateCode;
            return this;
        }

        public LocationBuilder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public LocationBuilder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public LocationBuilder timezoneOffset(Integer timezoneOffset) {
            this.timezoneOffset = timezoneOffset;
            return this;
        }

        public LocationBuilder lastUpdated(LocalDateTime lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        public LocationBuilder currentWeather(CurrentWeatherData currentWeather) {
            this.currentWeather = currentWeather;
            return this;
        }

        public LocationBuilder minutelyWeather(List<MinutelyWeatherData> minutelyWeather) {
            this.minutelyWeather = minutelyWeather;
            return this;
        }

        public LocationBuilder hourlyWeather(List<HourlyWeatherData> hourlyWeather) {
            this.hourlyWeather = hourlyWeather;
            return this;
        }

        public LocationBuilder dailyWeather(List<DailyWeatherData> dailyWeather) {
            this.dailyWeather = dailyWeather;
            return this;
        }

        public LocationBuilder alerts(List<WeatherAlert> alerts) {
            this.alerts = alerts;
            return this;
        }

        public Location build() {
            return new Location(id, latitude, longitude, cityName, stateCode, countryCode, timezone, timezoneOffset, lastUpdated,
                    currentWeather, minutelyWeather, hourlyWeather, dailyWeather, alerts);
        }
    }

    public static LocationBuilder builder() {
        return new LocationBuilder();
    }
}


