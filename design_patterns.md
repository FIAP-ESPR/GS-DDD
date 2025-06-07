# Padrões de Projeto para a API de Dados Meteorológicos

Este documento descreve os padrões de projeto que serão utilizados na implementação da API de Dados Meteorológicos, justificando sua escolha e benefícios.

## 1. Repository Pattern

### Descrição
O Repository Pattern é um padrão de projeto que separa a lógica de acesso a dados do resto da aplicação, fornecendo uma abstração das operações de persistência.

### Implementação
```java
public interface WeatherRepository extends JpaRepository<WeatherData, Long> {
    Optional<WeatherData> findByLatitudeAndLongitude(Double latitude, Double longitude);
    List<WeatherData> findByLatitudeBetweenAndLongitudeBetween(
        Double latMin, Double latMax, Double lonMin, Double lonMax);
}
```

### Justificativa
- **Desacoplamento**: Separa a lógica de acesso a dados da lógica de negócio.
- **Testabilidade**: Facilita a criação de mocks para testes unitários.
- **Manutenibilidade**: Centraliza o código de acesso a dados, facilitando alterações futuras.
- **Reutilização**: Permite reutilizar operações de acesso a dados em diferentes partes da aplicação.

## 2. Service Pattern

### Descrição
O Service Pattern encapsula a lógica de negócio da aplicação em serviços, que são componentes independentes e reutilizáveis.

### Implementação
```java
public interface WeatherService {
    WeatherDataDTO getWeatherData(Double latitude, Double longitude);
    WeatherDataDTO getForecast(Double latitude, Double longitude, List<String> include);
    List<WeatherAlertDTO> getAlerts(Double latitude, Double longitude);
}

@Service
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;
    private final LocationRepository locationRepository;
    
    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository, LocationRepository locationRepository) {
        this.weatherRepository = weatherRepository;
        this.locationRepository = locationRepository;
    }
    
    @Override
    public WeatherDataDTO getWeatherData(Double latitude, Double longitude) {
        // Implementação
    }
    
    // Outras implementações
}
```

### Justificativa
- **Separação de Responsabilidades**: Separa a lógica de negócio da lógica de apresentação.
- **Reutilização**: Permite reutilizar a lógica de negócio em diferentes controladores.
- **Testabilidade**: Facilita a criação de testes unitários para a lógica de negócio.
- **Manutenibilidade**: Centraliza a lógica de negócio, facilitando alterações futuras.

## 3. DTO (Data Transfer Object) Pattern

### Descrição
O DTO Pattern é utilizado para transferir dados entre camadas da aplicação, especialmente entre a camada de serviço e a camada de apresentação.

### Implementação
```java
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
    
    // Getters e Setters
}
```

### Justificativa
- **Desacoplamento**: Separa o modelo de domínio do modelo de apresentação.
- **Segurança**: Evita a exposição de informações sensíveis ou desnecessárias.
- **Flexibilidade**: Permite adaptar a estrutura de dados para diferentes necessidades de apresentação.
- **Performance**: Permite transferir apenas os dados necessários, reduzindo o tráfego de rede.

## 4. Factory Pattern

### Descrição
O Factory Pattern é utilizado para criar objetos sem expor a lógica de criação ao cliente, utilizando uma interface comum.

### Implementação
```java
public class WeatherDTOFactory {
    public static WeatherDataDTO createFromEntity(WeatherData entity) {
        WeatherDataDTO dto = new WeatherDataDTO();
        dto.setLat(entity.getLatitude());
        dto.setLon(entity.getLongitude());
        dto.setTimezone(entity.getTimezone());
        dto.setTimezone_offset(entity.getTimezoneOffset());
        
        // Configurar outros campos
        
        return dto;
    }
    
    public static CurrentWeatherDTO createCurrentWeatherDTO(CurrentWeatherData entity) {
        // Implementação
    }
    
    // Outros métodos factory
}
```

### Justificativa
- **Encapsulamento**: Encapsula a lógica de criação de objetos complexos.
- **Reutilização**: Permite reutilizar a lógica de criação de objetos em diferentes partes da aplicação.
- **Manutenibilidade**: Centraliza a lógica de criação de objetos, facilitando alterações futuras.
- **Flexibilidade**: Permite criar diferentes tipos de objetos com base em parâmetros.

## 5. Singleton Pattern

### Descrição
O Singleton Pattern garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a ela.

### Implementação
```java
@Component
public class WeatherDataCache {
    private static WeatherDataCache instance;
    private final Map<String, WeatherDataDTO> cache = new ConcurrentHashMap<>();
    
    private WeatherDataCache() {
        // Construtor privado
    }
    
    @PostConstruct
    private void init() {
        instance = this;
    }
    
    public static WeatherDataCache getInstance() {
        return instance;
    }
    
    public WeatherDataDTO get(String key) {
        return cache.get(key);
    }
    
    public void put(String key, WeatherDataDTO data) {
        cache.put(key, data);
    }
    
    public boolean contains(String key) {
        return cache.containsKey(key);
    }
}
```

### Justificativa
- **Controle de Acesso**: Garante que haja apenas uma instância da classe.
- **Economia de Recursos**: Evita a criação desnecessária de múltiplas instâncias.
- **Coordenação Global**: Fornece um ponto de acesso global para a instância.
- **Lazy Initialization**: Permite inicializar a instância apenas quando necessário.

## 6. Strategy Pattern

### Descrição
O Strategy Pattern define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis. Permite que o algoritmo varie independentemente dos clientes que o utilizam.

### Implementação
```java
public interface WeatherDataProvider {
    WeatherDataDTO getWeatherData(Double latitude, Double longitude);
}

@Component
public class DatabaseWeatherDataProvider implements WeatherDataProvider {
    private final WeatherRepository weatherRepository;
    
    @Autowired
    public DatabaseWeatherDataProvider(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }
    
    @Override
    public WeatherDataDTO getWeatherData(Double latitude, Double longitude) {
        // Implementação para buscar dados do banco de dados
    }
}

@Component
public class CachedWeatherDataProvider implements WeatherDataProvider {
    private final WeatherDataCache cache;
    private final DatabaseWeatherDataProvider databaseProvider;
    
    @Autowired
    public CachedWeatherDataProvider(WeatherDataCache cache, DatabaseWeatherDataProvider databaseProvider) {
        this.cache = cache;
        this.databaseProvider = databaseProvider;
    }
    
    @Override
    public WeatherDataDTO getWeatherData(Double latitude, Double longitude) {
        String key = latitude + ":" + longitude;
        if (cache.contains(key)) {
            return cache.get(key);
        }
        
        WeatherDataDTO data = databaseProvider.getWeatherData(latitude, longitude);
        cache.put(key, data);
        return data;
    }
}
```

### Justificativa
- **Flexibilidade**: Permite trocar algoritmos em tempo de execução.
- **Desacoplamento**: Separa o algoritmo do contexto que o utiliza.
- **Extensibilidade**: Facilita a adição de novos algoritmos sem modificar o código existente.
- **Testabilidade**: Facilita a criação de testes unitários para cada algoritmo.

## 7. Builder Pattern

### Descrição
O Builder Pattern separa a construção de um objeto complexo da sua representação, permitindo que o mesmo processo de construção crie diferentes representações.

### Implementação
```java
public class WeatherDataBuilder {
    private final WeatherDataDTO weatherData;
    
    public WeatherDataBuilder() {
        this.weatherData = new WeatherDataDTO();
    }
    
    public WeatherDataBuilder withLocation(double lat, double lon, String timezone, int timezoneOffset) {
        weatherData.setLat(lat);
        weatherData.setLon(lon);
        weatherData.setTimezone(timezone);
        weatherData.setTimezone_offset(timezoneOffset);
        return this;
    }
    
    public WeatherDataBuilder withCurrentWeather(CurrentWeatherDTO current) {
        weatherData.setCurrent(current);
        return this;
    }
    
    public WeatherDataBuilder withMinutelyForecast(List<MinutelyWeatherDTO> minutely) {
        weatherData.setMinutely(minutely);
        return this;
    }
    
    public WeatherDataBuilder withHourlyForecast(List<HourlyWeatherDTO> hourly) {
        weatherData.setHourly(hourly);
        return this;
    }
    
    public WeatherDataBuilder withDailyForecast(List<DailyWeatherDTO> daily) {
        weatherData.setDaily(daily);
        return this;
    }
    
    public WeatherDataBuilder withAlerts(List<WeatherAlertDTO> alerts) {
        weatherData.setAlerts(alerts);
        return this;
    }
    
    public WeatherDataDTO build() {
        return weatherData;
    }
}
```

### Justificativa
- **Construção Passo a Passo**: Permite construir objetos complexos passo a passo.
- **Variação de Representação**: Permite criar diferentes representações do mesmo objeto.
- **Encapsulamento**: Encapsula o código de construção e representação.
- **Legibilidade**: Torna o código de construção mais legível e expressivo.

## Conclusão

A utilização desses padrões de projeto na implementação da API de Dados Meteorológicos trará benefícios significativos em termos de manutenibilidade, testabilidade, flexibilidade e reutilização de código. Cada padrão foi escolhido com base nas necessidades específicas da aplicação e nas melhores práticas de desenvolvimento de software.

