/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.model.dto;

import java.util.List;
import java.util.Objects;

/**
 * DTO que representa os dados meteorológicos por hora.
 */
public class HourlyWeatherDTO {

    private long dt;
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
    private double pop;

    /**
     * Construtor padrão.
     */
    public HourlyWeatherDTO() {
    }

    /**
     * Construtor com todos os campos.
     */
    public HourlyWeatherDTO(long dt, double temp, double feels_like, int pressure, int humidity,
                            double dew_point, double uvi, int clouds, int visibility,
                            double wind_speed, int wind_deg, double wind_gust,
                            List<WeatherConditionDTO> weather, double pop) {
        this.dt = dt;
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
        this.pop = pop;
    }

    // Getters e Setters

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
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

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HourlyWeatherDTO that = (HourlyWeatherDTO) o;
        return dt == that.dt &&
                Double.compare(that.temp, temp) == 0 &&
                Double.compare(that.feels_like, feels_like) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dt, temp, feels_like);
    }

    @Override
    public String toString() {
        return "HourlyWeatherDTO{" +
                "dt=" + dt +
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
                ", weather=" + weather +
                ", pop=" + pop +
                "}";
    }

    /**
     * Builder para a classe HourlyWeatherDTO.
     */
    public static class HourlyWeatherDTOBuilder {
        private long dt;
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
        private double pop;

        public HourlyWeatherDTOBuilder() {
        }

        public HourlyWeatherDTOBuilder dt(long dt) {
            this.dt = dt;
            return this;
        }

        public HourlyWeatherDTOBuilder temp(double temp) {
            this.temp = temp;
            return this;
        }

        public HourlyWeatherDTOBuilder feels_like(double feels_like) {
            this.feels_like = feels_like;
            return this;
        }

        public HourlyWeatherDTOBuilder pressure(int pressure) {
            this.pressure = pressure;
            return this;
        }

        public HourlyWeatherDTOBuilder humidity(int humidity) {
            this.humidity = humidity;
            return this;
        }

        public HourlyWeatherDTOBuilder dew_point(double dew_point) {
            this.dew_point = dew_point;
            return this;
        }

        public HourlyWeatherDTOBuilder uvi(double uvi) {
            this.uvi = uvi;
            return this;
        }

        public HourlyWeatherDTOBuilder clouds(int clouds) {
            this.clouds = clouds;
            return this;
        }

        public HourlyWeatherDTOBuilder visibility(int visibility) {
            this.visibility = visibility;
            return this;
        }

        public HourlyWeatherDTOBuilder wind_speed(double wind_speed) {
            this.wind_speed = wind_speed;
            return this;
        }

        public HourlyWeatherDTOBuilder wind_deg(int wind_deg) {
            this.wind_deg = wind_deg;
            return this;
        }

        public HourlyWeatherDTOBuilder wind_gust(double wind_gust) {
            this.wind_gust = wind_gust;
            return this;
        }

        public HourlyWeatherDTOBuilder weather(List<WeatherConditionDTO> weather) {
            this.weather = weather;
            return this;
        }

        public HourlyWeatherDTOBuilder pop(double pop) {
            this.pop = pop;
            return this;
        }

        public HourlyWeatherDTO build() {
            return new HourlyWeatherDTO(dt, temp, feels_like, pressure, humidity, dew_point, uvi, clouds, visibility, wind_speed, wind_deg, wind_gust, weather, pop);
        }
    }

    public static HourlyWeatherDTOBuilder builder() {
        return new HourlyWeatherDTOBuilder();
    }
}

