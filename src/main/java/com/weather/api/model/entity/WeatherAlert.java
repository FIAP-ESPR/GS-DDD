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

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidade que representa um alerta meteorológico.
 */
@Entity
@Table(name = "weather_alerts")
public class WeatherAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(name = "sender_name", nullable = false)
    private String senderName;

    @Column(nullable = false)
    private String event;

    @Column(name = "start_time", nullable = false)
    private Long startTime;

    @Column(name = "end_time", nullable = false)
    private Long endTime;

    @Column(columnDefinition = "CLOB", nullable = false)
    private String description;

    @ElementCollection
    @CollectionTable(name = "alert_tags", joinColumns = @JoinColumn(name = "alert_id"))
    @Column(name = "tag")
    private List<String> tags = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public WeatherAlert() {
    }

    /**
     * Construtor com todos os campos.
     */
    public WeatherAlert(Long id, Location location, String senderName, String event, Long startTime,
                        Long endTime, String description, List<String> tags) {
        this.id = id;
        this.location = location;
        this.senderName = senderName;
        this.event = event;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.tags = tags != null ? tags : new ArrayList<>();
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

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
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
        WeatherAlert that = (WeatherAlert) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WeatherAlert{" +
                "id=" + id +
                ", senderName=\"" + senderName + "\"" +
                ", event=\"" + event + "\"" +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                "}";
    }

    /**
     * Builder para a classe WeatherAlert.
     */
    public static class WeatherAlertBuilder {
        private Long id;
        private Location location;
        private String senderName;
        private String event;
        private Long startTime;
        private Long endTime;
        private String description;
        private List<String> tags = new ArrayList<>();

        public WeatherAlertBuilder() {
        }

        public WeatherAlertBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public WeatherAlertBuilder location(Location location) {
            this.location = location;
            return this;
        }

        public WeatherAlertBuilder senderName(String senderName) {
            this.senderName = senderName;
            return this;
        }

        public WeatherAlertBuilder event(String event) {
            this.event = event;
            return this;
        }

        public WeatherAlertBuilder startTime(Long startTime) {
            this.startTime = startTime;
            return this;
        }

        public WeatherAlertBuilder endTime(Long endTime) {
            this.endTime = endTime;
            return this;
        }

        public WeatherAlertBuilder description(String description) {
            this.description = description;
            return this;
        }

        public WeatherAlertBuilder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public WeatherAlert build() {
            return new WeatherAlert(id, location, senderName, event, startTime, endTime, description, tags);
        }
    }

    public static WeatherAlertBuilder builder() {
        return new WeatherAlertBuilder();
    }
}

