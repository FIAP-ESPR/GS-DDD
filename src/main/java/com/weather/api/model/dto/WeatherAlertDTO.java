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
 * DTO que representa um alerta meteorológico.
 */
public class WeatherAlertDTO {

    private String sender_name;
    private String event;
    private long start_time;
    private long end_time;
    private String description;
    private List<String> tags;

    /**
     * Construtor padrão.
     */
    public WeatherAlertDTO() {
    }

    /**
     * Construtor com todos os campos.
     */
    public WeatherAlertDTO(String sender_name, String event, long start_time, long end_time, String description, List<String> tags) {
        this.sender_name = sender_name;
        this.event = event;
        this.start_time = start_time;
        this.end_time = end_time;
        this.description = description;
        this.tags = tags;
    }

    // Getters e Setters

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherAlertDTO that = (WeatherAlertDTO) o;
        return start_time == that.start_time &&
                end_time == that.end_time &&
                Objects.equals(sender_name, that.sender_name) &&
                Objects.equals(event, that.event) &&
                Objects.equals(description, that.description) &&
                Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender_name, event, start_time, end_time, description, tags);
    }

    @Override
    public String toString() {
        return "WeatherAlertDTO{" +
                "sender_name=\"" + sender_name + "\"" +
                ", event=\"" + event + "\"" +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", description=\"" + description + "\"" +
                ", tags=" + tags +
                "}";
    }

    /**
     * Builder para a classe WeatherAlertDTO.
     */
    public static class WeatherAlertDTOBuilder {
        private String sender_name;
        private String event;
        private long start_time;
        private long end_time;
        private String description;
        private List<String> tags;

        public WeatherAlertDTOBuilder() {
        }

        public WeatherAlertDTOBuilder sender_name(String sender_name) {
            this.sender_name = sender_name;
            return this;
        }

        public WeatherAlertDTOBuilder event(String event) {
            this.event = event;
            return this;
        }

        public WeatherAlertDTOBuilder start_time(long start_time) {
            this.start_time = start_time;
            return this;
        }

        public WeatherAlertDTOBuilder end_time(long end_time) {
            this.end_time = end_time;
            return this;
        }

        public WeatherAlertDTOBuilder description(String description) {
            this.description = description;
            return this;
        }

        public WeatherAlertDTOBuilder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public WeatherAlertDTO build() {
            return new WeatherAlertDTO(sender_name, event, start_time, end_time, description, tags);
        }
    }

    public static WeatherAlertDTOBuilder builder() {
        return new WeatherAlertDTOBuilder();
    }
}

