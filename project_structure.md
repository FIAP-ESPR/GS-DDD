# Estrutura do Projeto para API de Dados Meteorológicos

## Visão Geral

Este projeto será desenvolvido como uma aplicação Spring Boot para ser executada no Eclipse IDE. A estrutura seguirá o padrão de arquitetura em camadas (MVC + Service) com as seguintes camadas:

1. **Controller**: Responsável por receber as requisições HTTP e encaminhá-las para os serviços apropriados.
2. **Service**: Contém a lógica de negócio da aplicação.
3. **Repository**: Responsável pela comunicação com o banco de dados.
4. **Model**: Contém as entidades JPA e os DTOs (Data Transfer Objects).
5. **Config**: Contém as configurações da aplicação.
6. **Exception**: Contém as classes de exceção personalizadas.
7. **Util**: Contém classes utilitárias.

## Estrutura de Pacotes

```
com.weather.api/
├── controller/
│   └── WeatherController.java
├── service/
│   ├── WeatherService.java
│   └── WeatherServiceImpl.java
├── repository/
│   ├── WeatherRepository.java
│   └── LocationRepository.java
├── model/
│   ├── entity/
│   │   ├── Location.java
│   │   ├── CurrentWeatherData.java
│   │   ├── HourlyWeatherData.java
│   │   ├── DailyWeatherData.java
│   │   ├── WeatherCondition.java
│   │   └── WeatherAlert.java
│   └── dto/
│       ├── WeatherDataDTO.java
│       ├── CurrentWeatherDTO.java
│       ├── MinutelyWeatherDTO.java
│       ├── HourlyWeatherDTO.java
│       ├── DailyWeatherDTO.java
│       ├── DailyTemperatureDTO.java
│       ├── DailyFeelsLikeDTO.java
│       ├── WeatherConditionDTO.java
│       └── WeatherAlertDTO.java
├── config/
│   └── DatabaseConfig.java
├── exception/
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
└── util/
    └── DateTimeUtil.java
```

## Tecnologias Utilizadas

- **Spring Boot**: Framework para desenvolvimento de aplicações Java
- **Spring Data JPA**: Para persistência de dados
- **H2 Database**: Banco de dados em memória para desenvolvimento
- **Lombok**: Para reduzir código boilerplate
- **ModelMapper**: Para mapeamento entre entidades e DTOs
- **Swagger/OpenAPI**: Para documentação da API

## Banco de Dados

Para este projeto, utilizaremos o H2 Database, um banco de dados em memória que é ideal para desenvolvimento e testes. O esquema do banco de dados será definido através das entidades JPA.

### Entidades Principais

1. **Location**
   - id (PK)
   - latitude
   - longitude
   - timezone
   - timezone_offset
   - last_updated

2. **CurrentWeatherData**
   - id (PK)
   - location_id (FK)
   - dt (timestamp)
   - sunrise
   - sunset
   - temp
   - feels_like
   - pressure
   - humidity
   - dew_point
   - uvi
   - clouds
   - visibility
   - wind_speed
   - wind_deg
   - wind_gust

3. **WeatherCondition**
   - id (PK)
   - weather_data_id (FK)
   - weather_data_type (discriminator)
   - condition_id
   - main
   - description
   - icon

4. **HourlyWeatherData**
   - id (PK)
   - location_id (FK)
   - dt (timestamp)
   - temp
   - feels_like
   - pressure
   - humidity
   - dew_point
   - uvi
   - clouds
   - visibility
   - wind_speed
   - wind_deg
   - wind_gust
   - pop (probability of precipitation)

5. **DailyWeatherData**
   - id (PK)
   - location_id (FK)
   - dt (timestamp)
   - sunrise
   - sunset
   - moonrise
   - moonset
   - moon_phase
   - summary
   - temp_day
   - temp_min
   - temp_max
   - temp_night
   - temp_eve
   - temp_morn
   - feels_like_day
   - feels_like_night
   - feels_like_eve
   - feels_like_morn
   - pressure
   - humidity
   - dew_point
   - wind_speed
   - wind_deg
   - wind_gust
   - clouds
   - pop
   - rain
   - uvi

6. **WeatherAlert**
   - id (PK)
   - location_id (FK)
   - sender_name
   - event
   - start_time
   - end_time
   - description

7. **AlertTag**
   - id (PK)
   - alert_id (FK)
   - tag

## Relacionamentos

- **Location** tem muitos **CurrentWeatherData** (1:1 para o mais recente)
- **Location** tem muitos **HourlyWeatherData** (1:N)
- **Location** tem muitos **DailyWeatherData** (1:N)
- **Location** tem muitos **WeatherAlert** (1:N)
- **CurrentWeatherData**, **HourlyWeatherData**, **DailyWeatherData** têm muitos **WeatherCondition** (1:N)
- **WeatherAlert** tem muitos **AlertTag** (1:N)

## Configuração do Banco de Dados (application.properties)

```properties
# H2 Database
spring.datasource.url=jdbc:h2:mem:weatherdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Esta estrutura fornece uma base sólida para o desenvolvimento da API de dados meteorológicos, seguindo as melhores práticas de desenvolvimento Java e Spring Boot.

