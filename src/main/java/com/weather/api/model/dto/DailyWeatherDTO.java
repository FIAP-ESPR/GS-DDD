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
 * DTO que representa os dados meteorológicos diários.
 */
public class DailyWeatherDTO {

    private long dt;
    private long sunrise;
    private long sunset;
    private long moonrise;
    private long moonset;
    private double moon_phase;
    private String summary;
    private DailyTemperatureDTO temp;
    private DailyFeelsLikeDTO feels_like;
    private int pressure;
    private int humidity;
    private double dew_point;
    private double wind_speed;
    private int wind_deg;
    private double wind_gust;
    private int clouds;
    private double pop;
    private double rain;
    private double uvi;
    private List<WeatherConditionDTO> weather;

    /**
     * Construtor padrão.
     */
    public DailyWeatherDTO() {
    }

    /**
     * Construtor com todos os campos.
     */
    public DailyWeatherDTO(long dt, long sunrise, long sunset, long moonrise, long moonset,
                           double moon_phase, String summary, DailyTemperatureDTO temp,
                           DailyFeelsLikeDTO feels_like, int pressure, int humidity,
                           double dew_point, double wind_speed, int wind_deg, double wind_gust,
                           int clouds, double pop, double rain, double uvi,
                           List<WeatherConditionDTO> weather) {
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
        this.moon_phase = moon_phase;
        this.summary = summary;
        this.temp = temp;
        this.feels_like = feels_like;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dew_point = dew_point;
        this.wind_speed = wind_speed;
        this.wind_deg = wind_deg;
        this.wind_gust = wind_gust;
        this.clouds = clouds;
        this.pop = pop;
        this.rain = rain;
        this.uvi = uvi;
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

    public long getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(long moonrise) {
        this.moonrise = moonrise;
    }

    public long getMoonset() {
        return moonset;
    }

    public void setMoonset(long moonset) {
        this.moonset = moonset;
    }

    public double getMoon_phase() {
        return moon_phase;
    }

    public void setMoon_phase(double moon_phase) {
        this.moon_phase = moon_phase;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public DailyTemperatureDTO getTemp() {
        return temp;
    }

    public void setTemp(DailyTemperatureDTO temp) {
        this.temp = temp;
    }

    public DailyFeelsLikeDTO getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(DailyFeelsLikeDTO feels_like) {
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

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public double getUvi() {
        return uvi;
    }

    public void setUvi(double uvi) {
        this.uvi = uvi;
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
        DailyWeatherDTO that = (DailyWeatherDTO) o;
        return dt == that.dt &&
                sunrise == that.sunrise &&
                sunset == that.sunset &&
                moonrise == that.moonrise &&
                moonset == that.moonset &&
                Double.compare(that.moon_phase, moon_phase) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dt, sunrise, sunset, moonrise, moonset, moon_phase);
    }

    @Override
    public String toString() {
        return "DailyWeatherDTO{" +
                "dt=" + dt +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", moonrise=" + moonrise +
                ", moonset=" + moonset +
                ", moon_phase=" + moon_phase +
                ", summary=\"" + summary + "\"" +
                ", temp=" + temp +
                ", feels_like=" + feels_like +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", dew_point=" + dew_point +
                ", wind_speed=" + wind_speed +
                ", wind_deg=" + wind_deg +
                ", wind_gust=" + wind_gust +
                ", clouds=" + clouds +
                ", pop=" + pop +
                ", rain=" + rain +
                ", uvi=" + uvi +
                "}";
    }

    /**
     * Builder para a classe DailyWeatherDTO.
     */
    public static class DailyWeatherDTOBuilder {
        private long dt;
        private long sunrise;
        private long sunset;
        private long moonrise;
        private long moonset;
        private double moon_phase;
        private String summary;
        private DailyTemperatureDTO temp;
        private DailyFeelsLikeDTO feels_like;
        private int pressure;
        private int humidity;
        private double dew_point;
        private double wind_speed;
        private int wind_deg;
        private double wind_gust;
        private int clouds;
        private double pop;
        private double rain;
        private double uvi;
        private List<WeatherConditionDTO> weather;

        public DailyWeatherDTOBuilder() {
        }

        public DailyWeatherDTOBuilder dt(long dt) {
            this.dt = dt;
            return this;
        }

        public DailyWeatherDTOBuilder sunrise(long sunrise) {
            this.sunrise = sunrise;
            return this;
        }

        public DailyWeatherDTOBuilder sunset(long sunset) {
            this.sunset = sunset;
            return this;
        }

        public DailyWeatherDTOBuilder moonrise(long moonrise) {
            this.moonrise = moonrise;
            return this;
        }

        public DailyWeatherDTOBuilder moonset(long moonset) {
            this.moonset = moonset;
            return this;
        }

        public DailyWeatherDTOBuilder moon_phase(double moon_phase) {
            this.moon_phase = moon_phase;
            return this;
        }

        public DailyWeatherDTOBuilder summary(String summary) {
            this.summary = summary;
            return this;
        }

        public DailyWeatherDTOBuilder temp(DailyTemperatureDTO temp) {
            this.temp = temp;
            return this;
        }

        public DailyWeatherDTOBuilder feels_like(DailyFeelsLikeDTO feels_like) {
            this.feels_like = feels_like;
            return this;
        }

        public DailyWeatherDTOBuilder pressure(int pressure) {
            this.pressure = pressure;
            return this;
        }

        public DailyWeatherDTOBuilder humidity(int humidity) {
            this.humidity = humidity;
            return this;
        }

        public DailyWeatherDTOBuilder dew_point(double dew_point) {
            this.dew_point = dew_point;
            return this;
        }

        public DailyWeatherDTOBuilder wind_speed(double wind_speed) {
            this.wind_speed = wind_speed;
            return this;
        }

        public DailyWeatherDTOBuilder wind_deg(int wind_deg) {
            this.wind_deg = wind_deg;
            return this;
        }

        public DailyWeatherDTOBuilder wind_gust(double wind_gust) {
            this.wind_gust = wind_gust;
            return this;
        }

        public DailyWeatherDTOBuilder clouds(int clouds) {
            this.clouds = clouds;
            return this;
        }

        public DailyWeatherDTOBuilder pop(double pop) {
            this.pop = pop;
            return this;
        }

        public DailyWeatherDTOBuilder rain(double rain) {
            this.rain = rain;
            return this;
        }

        public DailyWeatherDTOBuilder uvi(double uvi) {
            this.uvi = uvi;
            return this;
        }

        public DailyWeatherDTOBuilder weather(List<WeatherConditionDTO> weather) {
            this.weather = weather;
            return this;
        }

        public DailyWeatherDTO build() {
            return new DailyWeatherDTO(dt, sunrise, sunset, moonrise, moonset, moon_phase, summary, temp,
                    feels_like, pressure, humidity, dew_point, wind_speed, wind_deg, wind_gust, clouds, pop, rain, uvi, weather);
        }
    }

    public static DailyWeatherDTOBuilder builder() {
        return new DailyWeatherDTOBuilder();
    }
}

