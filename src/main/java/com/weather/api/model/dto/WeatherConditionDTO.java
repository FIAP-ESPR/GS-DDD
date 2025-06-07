/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.model.dto;

import java.util.Objects;

/**
 * DTO que representa uma condição meteorológica.
 */
public class WeatherConditionDTO {

    private int id;
    private String main;
    private String description;
    private String icon;

    /**
     * Construtor padrão.
     */
    public WeatherConditionDTO() {
    }

    /**
     * Construtor com todos os campos.
     */
    public WeatherConditionDTO(int id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherConditionDTO that = (WeatherConditionDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WeatherConditionDTO{" +
                "id=" + id +
                ", main=\"" + main + "\"" +
                ", description=\"" + description + "\"" +
                ", icon=\"" + icon + "\"" +
                "}";
    }

    /**
     * Builder para a classe WeatherConditionDTO.
     */
    public static class WeatherConditionDTOBuilder {
        private int id;
        private String main;
        private String description;
        private String icon;

        public WeatherConditionDTOBuilder() {
        }

        public WeatherConditionDTOBuilder id(int id) {
            this.id = id;
            return this;
        }

        public WeatherConditionDTOBuilder main(String main) {
            this.main = main;
            return this;
        }

        public WeatherConditionDTOBuilder description(String description) {
            this.description = description;
            return this;
        }

        public WeatherConditionDTOBuilder icon(String icon) {
            this.icon = icon;
            return this;
        }

        public WeatherConditionDTO build() {
            return new WeatherConditionDTO(id, main, description, icon);
        }
    }

    public static WeatherConditionDTOBuilder builder() {
        return new WeatherConditionDTOBuilder();
    }
}

