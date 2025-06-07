/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Configuração do OpenAPI (Swagger).
 */
@Configuration
public class OpenApiConfig {

    /**
     * Configura o OpenAPI.
     *
     * @return OpenAPI
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Dados Meteorológicos")
                        .description("API para obtenção de dados meteorológicos com base em coordenadas geográficas")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipe de Desenvolvimento")
                                .email("contato@weather.com")
                                .url("https://weather.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}

