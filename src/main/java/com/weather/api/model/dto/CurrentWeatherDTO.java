package com.weather.api.model.dto;

import java.util.List;
import java.util.Objects;

/**
 * DTO que representa os dados meteorológicos atuais.
 */
public class CurrentWeatherDTO {

    private long dt;
    private long sunrise;
    private long sunset;
    private double temp;
    private double feels_like;
    private int pressure;
    private int humidity;
    private double dew_point;
    private double uvi;
    private int clouds;
    private int visibility;
    private double wind_speed;
    private int wind_deg;
    private double wind_gust;
    private List<WeatherConditionDTO> weather;

    /**
     * Construtor padrão.
     */
    public CurrentWeatherDTO() {
    }

    /**
     * Construtor com todos os campos.
     */
    public CurrentWeatherDTO(long dt, long sunrise, long sunset, double temp, double feels_like,
                            int pressure, int humidity, double dew_point, double uvi, int clouds,
                            int visibility, double wind_speed, int wind_deg, double wind_gust,
                            List<WeatherConditionDTO> weather) {
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.temp = temp;
        this.feels_like = feels_like;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dew_point = dew_point;
        this.uvi = uvi;
        this.clouds = clouds;
        this.visibility = visibility;
        this.wind_speed = wind_speed;
        this.wind_deg = wind_deg;
        this.wind_gust = wind_gust;
        this.weather = weather;
    }

    // Getters e Setters

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getDew_point() {
        return dew_point;
    }

    public void setDew_point(double dew_point) {
        this.dew_point = dew_point;
    }

    public double getUvi() {
        return uvi;
    }

    public void setUvi(double uvi) {
        this.uvi = uvi;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public int getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(int wind_deg) {
        this.wind_deg = wind_deg;
    }

    public double getWind_gust() {
        return wind_gust;
    }

    public void setWind_gust(double wind_gust) {
        this.wind_gust = wind_gust;
    }

    public List<WeatherConditionDTO> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherConditionDTO> weather) {
        this.weather = weather;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentWeatherDTO that = (CurrentWeatherDTO) o;
        return dt == that.dt &&
                sunrise == that.sunrise &&
                sunset == that.sunset;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dt, sunrise, sunset);
    }

    @Override
    public String toString() {
        return "CurrentWeatherDTO{" +
                "dt=" + dt +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", temp=" + temp +
                ", feels_like=" + feels_like +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", dew_point=" + dew_point +
                ", uvi=" + uvi +
                ", clouds=" + clouds +
                ", visibility=" + visibility +
                ", wind_speed=" + wind_speed +
                ", wind_deg=" + wind_deg +
                ", wind_gust=" + wind_gust +
                '}';
    }

    /**
     * Builder para a classe CurrentWeatherDTO.
     */
    public static class CurrentWeatherDTOBuilder {
        private long dt;
        private long sunrise;
        private long sunset;
        private double temp;
        private double feels_like;
        private int pressure;
        private int humidity;
        private double dew_point;
        private double uvi;
        private int clouds;
        private int visibility;
        private double wind_speed;
        private int wind_deg;
        private double wind_gust;
        private List<WeatherConditionDTO> weather;

        public CurrentWeatherDTOBuilder() {
        }

        public CurrentWeatherDTOBuilder dt(long dt) {
            this.dt = dt;
            return this;
        }

        public CurrentWeatherDTOBuilder sunrise(long sunrise) {
            this.sunrise = sunrise;
            return this;
        }

        public CurrentWeatherDTOBuilder sunset(long sunset) {
            this.sunset = sunset;
            return this;
        }

        public CurrentWeatherDTOBuilder temp(double temp) {
            this.temp = temp;
            return this;
        }

        public CurrentWeatherDTOBuilder feels_like(double feels_like) {
            this.feels_like = feels_like;
            return this;
        }

        public CurrentWeatherDTOBuilder pressure(int pressure) {
            this.pressure = pressure;
            return this;
        }

        public CurrentWeatherDTOBuilder humidity(int humidity) {
            this.humidity = humidity;
            return this;
        }

        public CurrentWeatherDTOBuilder dew_point(double dew_point) {
            this.dew_point = dew_point;
            return this;
        }

        public CurrentWeatherDTOBuilder uvi(double uvi) {
            this.uvi = uvi;
            return this;
        }

        public CurrentWeatherDTOBuilder clouds(int clouds) {
            this.clouds = clouds;
            return this;
        }

        public CurrentWeatherDTOBuilder visibility(int visibility) {
            this.visibility = visibility;
            return this;
        }

        public CurrentWeatherDTOBuilder wind_speed(double wind_speed) {
            this.wind_speed = wind_speed;
            return this;
        }

        public CurrentWeatherDTOBuilder wind_deg(int wind_deg) {
            this.wind_deg = wind_deg;
            return this;
        }

        public CurrentWeatherDTOBuilder wind_gust(double wind_gust) {
            this.wind_gust = wind_gust;
            return this;
        }

        public CurrentWeatherDTOBuilder weather(List<WeatherConditionDTO> weather) {
            this.weather = weather;
            return this;
        }

        public CurrentWeatherDTO build() {
            return new CurrentWeatherDTO(dt, sunrise, sunset, temp, feels_like, pressure, humidity,
                    dew_point, uvi, clouds, visibility, wind_speed, wind_deg, wind_gust, weather);
        }
    }

    public static CurrentWeatherDTOBuilder builder() {
        return new CurrentWeatherDTOBuilder();
    }
}

