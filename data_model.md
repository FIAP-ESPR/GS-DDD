## Modelo de Dados para a API de Dados Meteorológicos

Com base no formato JSON fornecido, a API necessitará de um modelo de dados que represente as informações meteorológicas. Abaixo está uma proposta de classes Java que podem ser utilizadas para mapear os dados do banco de dados e para a resposta da API.

### 1. WeatherData (Classe Principal da Resposta)
Esta classe representará a estrutura completa da resposta JSON.

```java
public class WeatherData {
    private double lat;
    private double lon;
    private String timezone;
    private int timezone_offset;
    private CurrentWeather current;
    private List<MinutelyWeather> minutely;
    private List<HourlyWeather> hourly;
    private List<DailyWeather> daily;
    private List<WeatherAlert> alerts;

    // Getters e Setters
}
```

### 2. CurrentWeather
Representa os dados meteorológicos atuais.

```java
public class CurrentWeather {
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
    private List<WeatherCondition> weather;

    // Getters e Setters
}
```

### 3. MinutelyWeather
Representa os dados meteorológicos minuto a minuto.

```java
public class MinutelyWeather {
    private long dt;
    private double precipitation;

    // Getters e Setters
}
```

### 4. HourlyWeather
Representa os dados meteorológicos hora a hora.

```java
public class HourlyWeather {
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
    private List<WeatherCondition> weather;
    private double pop;

    // Getters e Setters
}
```

### 5. DailyWeather
Representa os dados meteorológicos diários.

```java
public class DailyWeather {
    private long dt;
    private long sunrise;
    private long sunset;
    private long moonrise;
    private long moonset;
    private double moon_phase;
    private String summary;
    private DailyTemperature temp;
    private DailyFeelsLike feels_like;
    private int pressure;
    private int humidity;
    private double dew_point;
    private double wind_speed;
    private int wind_deg;
    private double wind_gust;
    private List<WeatherCondition> weather;
    private int clouds;
    private double pop;
    private double rain;
    private double uvi;

    // Getters e Setters
}
```

### 6. DailyTemperature
Sub-classe para as temperaturas diárias.

```java
public class DailyTemperature {
    private double day;
    private double min;
    private double max;
    private double night;
    private double eve;
    private double morn;

    // Getters e Setters
}
```

### 7. DailyFeelsLike
Sub-classe para a sensação térmica diária.

```java
public class DailyFeelsLike {
    private double day;
    private double night;
    private double eve;
    private double morn;

    // Getters e Setters
}
```

### 8. WeatherCondition
Representa as condições meteorológicas (nuvens, chuva, etc.).

```java
public class WeatherCondition {
    private int id;
    private String main;
    private String description;
    private String icon;

    // Getters e Setters
}
```

### 9. WeatherAlert
Representa os alertas meteorológicos.

```java
public class WeatherAlert {
    private String sender_name;
    private String event;
    private long start;
    private long end;
    private String description;
    private List<String> tags;

    // Getters e Setters
}
```

Este modelo de dados servirá como base para a criação das entidades JPA (se usarmos um ORM) e dos DTOs (Data Transfer Objects) para a resposta da API.

