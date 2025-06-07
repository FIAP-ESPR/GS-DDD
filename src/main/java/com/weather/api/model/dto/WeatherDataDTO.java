package com.weather.api.model.dto;

import java.util.List;
import java.util.Objects;

/**
 * DTO que representa os dados meteorológicos completos.
 */
public class WeatherDataDTO {

    private double lat;
    private double lon;
    private String timezone;
    private int timezone_offset;
    private CurrentWeatherDTO current;
    private List<MinutelyWeatherDTO> minutely;
    private List<HourlyWeatherDTO> hourly;
    private List<DailyWeatherDTO> daily;
    private List<WeatherAlertDTO> alerts;

    /**
     * Construtor padrão.
     */
    public WeatherDataDTO() {
    }

    /**
     * Construtor com todos os campos.
     */
    public WeatherDataDTO(double lat, double lon, String timezone, int timezone_offset,
                         CurrentWeatherDTO current, List<MinutelyWeatherDTO> minutely,
                         List<HourlyWeatherDTO> hourly, List<DailyWeatherDTO> daily,
                         List<WeatherAlertDTO> alerts) {
        this.lat = lat;
        this.lon = lon;
        this.timezone = timezone;
        this.timezone_offset = timezone_offset;
        this.current = current;
        this.minutely = minutely;
        this.hourly = hourly;
        this.daily = daily;
        this.alerts = alerts;
    }

    // Getters e Setters

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(int timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public CurrentWeatherDTO getCurrent() {
        return current;
    }

    public void setCurrent(CurrentWeatherDTO current) {
        this.current = current;
    }

    public List<MinutelyWeatherDTO> getMinutely() {
        return minutely;
    }

    public void setMinutely(List<MinutelyWeatherDTO> minutely) {
        this.minutely = minutely;
    }

    public List<HourlyWeatherDTO> getHourly() {
        return hourly;
    }

    public void setHourly(List<HourlyWeatherDTO> hourly) {
        this.hourly = hourly;
    }

    public List<DailyWeatherDTO> getDaily() {
        return daily;
    }

    public void setDaily(List<DailyWeatherDTO> daily) {
        this.daily = daily;
    }

    public List<WeatherAlertDTO> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<WeatherAlertDTO> alerts) {
        this.alerts = alerts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherDataDTO that = (WeatherDataDTO) o;
        return Double.compare(that.lat, lat) == 0 &&
                Double.compare(that.lon, lon) == 0 &&
                timezone_offset == that.timezone_offset &&
                Objects.equals(timezone, that.timezone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon, timezone, timezone_offset);
    }

    @Override
    public String toString() {
        return "WeatherDataDTO{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", timezone='" + timezone + '\'' +
                ", timezone_offset=" + timezone_offset +
                '}';
    }

    /**
     * Builder para a classe WeatherDataDTO.
     */
    public static class WeatherDataDTOBuilder {
        private double lat;
        private double lon;
        private String timezone;
        private int timezone_offset;
        private CurrentWeatherDTO current;
        private List<MinutelyWeatherDTO> minutely;
        private List<HourlyWeatherDTO> hourly;
        private List<DailyWeatherDTO> daily;
        private List<WeatherAlertDTO> alerts;

        public WeatherDataDTOBuilder() {
        }

        public WeatherDataDTOBuilder lat(double lat) {
            this.lat = lat;
            return this;
        }

        public WeatherDataDTOBuilder lon(double lon) {
            this.lon = lon;
            return this;
        }

        public WeatherDataDTOBuilder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public WeatherDataDTOBuilder timezone_offset(int timezone_offset) {
            this.timezone_offset = timezone_offset;
            return this;
        }

        public WeatherDataDTOBuilder current(CurrentWeatherDTO current) {
            this.current = current;
            return this;
        }

        public WeatherDataDTOBuilder minutely(List<MinutelyWeatherDTO> minutely) {
            this.minutely = minutely;
            return this;
        }

        public WeatherDataDTOBuilder hourly(List<HourlyWeatherDTO> hourly) {
            this.hourly = hourly;
            return this;
        }

        public WeatherDataDTOBuilder daily(List<DailyWeatherDTO> daily) {
            this.daily = daily;
            return this;
        }

        public WeatherDataDTOBuilder alerts(List<WeatherAlertDTO> alerts) {
            this.alerts = alerts;
            return this;
        }

        public WeatherDataDTO build() {
            return new WeatherDataDTO(lat, lon, timezone, timezone_offset, current, minutely, hourly, daily, alerts);
        }
    }

    public static WeatherDataDTOBuilder builder() {
        return new WeatherDataDTOBuilder();
    }
}

