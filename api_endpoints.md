# Endpoints da API de Dados Meteorológicos

## Visão Geral

A API de Dados Meteorológicos fornecerá endpoints RESTful para obter informações meteorológicas com base em coordenadas geográficas (latitude e longitude). Os endpoints seguirão as melhores práticas REST e retornarão dados no formato JSON.

## Endpoints Principais

### 1. Obter Dados Meteorológicos Atuais

**Endpoint:** `GET /api/weather/current`

**Parâmetros de Consulta:**
- `lat` (obrigatório): Latitude da localização
- `lon` (obrigatório): Longitude da localização

**Resposta de Sucesso:**
- Código: 200 OK
- Corpo: Objeto JSON contendo os dados meteorológicos atuais

**Exemplo de Requisição:**
```
GET /api/weather/current?lat=33.44&lon=-94.04
```

**Exemplo de Resposta:**
```json
{
   "lat": 33.44,
   "lon": -94.04,
   "timezone": "America/Chicago",
   "timezone_offset": -18000,
   "current": {
      "dt": 1684929490,
      "sunrise": 1684926645,
      "sunset": 1684977332,
      "temp": 292.55,
      "feels_like": 292.87,
      "pressure": 1014,
      "humidity": 89,
      "dew_point": 290.69,
      "uvi": 0.16,
      "clouds": 53,
      "visibility": 10000,
      "wind_speed": 3.13,
      "wind_deg": 93,
      "wind_gust": 6.71,
      "weather": [
         {
            "id": 803,
            "main": "Clouds",
            "description": "broken clouds",
            "icon": "04d"
         }
      ]
   }
}
```

### 2. Obter Previsão Meteorológica Completa

**Endpoint:** `GET /api/weather/forecast`

**Parâmetros de Consulta:**
- `lat` (obrigatório): Latitude da localização
- `lon` (obrigatório): Longitude da localização
- `include` (opcional): Tipos de dados a incluir (current, minutely, hourly, daily, alerts)

**Resposta de Sucesso:**
- Código: 200 OK
- Corpo: Objeto JSON contendo a previsão meteorológica completa

**Exemplo de Requisição:**
```
GET /api/weather/forecast?lat=33.44&lon=-94.04&include=current,daily,alerts
```

**Exemplo de Resposta:**
```json
{
   "lat": 33.44,
   "lon": -94.04,
   "timezone": "America/Chicago",
   "timezone_offset": -18000,
   "current": {
      "dt": 1684929490,
      "sunrise": 1684926645,
      "sunset": 1684977332,
      "temp": 292.55,
      "feels_like": 292.87,
      "pressure": 1014,
      "humidity": 89,
      "dew_point": 290.69,
      "uvi": 0.16,
      "clouds": 53,
      "visibility": 10000,
      "wind_speed": 3.13,
      "wind_deg": 93,
      "wind_gust": 6.71,
      "weather": [
         {
            "id": 803,
            "main": "Clouds",
            "description": "broken clouds",
            "icon": "04d"
         }
      ]
   },
   "daily": [
      {
         "dt": 1684951200,
         "sunrise": 1684926645,
         "sunset": 1684977332,
         "moonrise": 1684941060,
         "moonset": 1684905480,
         "moon_phase": 0.16,
         "summary": "Expect a day of partly cloudy with rain",
         "temp": {
            "day": 299.03,
            "min": 290.69,
            "max": 300.35,
            "night": 291.45,
            "eve": 297.51,
            "morn": 292.55
         },
         "feels_like": {
            "day": 299.21,
            "night": 291.37,
            "eve": 297.86,
            "morn": 292.87
         },
         "pressure": 1016,
         "humidity": 59,
         "dew_point": 290.48,
         "wind_speed": 3.98,
         "wind_deg": 76,
         "wind_gust": 8.92,
         "weather": [
            {
               "id": 500,
               "main": "Rain",
               "description": "light rain",
               "icon": "10d"
            }
         ],
         "clouds": 92,
         "pop": 0.47,
         "rain": 0.15,
         "uvi": 9.23
      }
   ],
   "alerts": [
      {
         "sender_name": "NWS Philadelphia - Mount Holly (New Jersey, Delaware, Southeastern Pennsylvania)",
         "event": "Small Craft Advisory",
         "start": 1684952747,
         "end": 1684988747,
         "description": "...SMALL CRAFT ADVISORY REMAINS IN EFFECT FROM 5 PM THIS\nAFTERNOON TO 3 AM EST FRIDAY...\n* WHAT...North winds 15 to 20 kt with gusts up to 25 kt and seas\n3 to 5 ft expected.\n* WHERE...Coastal waters from Little Egg Inlet to Great Egg\nInlet NJ out 20 nm, Coastal waters from Great Egg Inlet to\nCape May NJ out 20 nm and Coastal waters from Manasquan Inlet\nto Little Egg Inlet NJ out 20 nm.\n* WHEN...From 5 PM this afternoon to 3 AM EST Friday.\n* IMPACTS...Conditions will be hazardous to small craft.",
         "tags": []
      }
   ]
}
```

### 3. Obter Previsão Diária

**Endpoint:** `GET /api/weather/daily`

**Parâmetros de Consulta:**
- `lat` (obrigatório): Latitude da localização
- `lon` (obrigatório): Longitude da localização
- `days` (opcional): Número de dias para a previsão (padrão: 7)

**Resposta de Sucesso:**
- Código: 200 OK
- Corpo: Objeto JSON contendo a previsão diária

**Exemplo de Requisição:**
```
GET /api/weather/daily?lat=33.44&lon=-94.04&days=3
```

**Exemplo de Resposta:**
```json
{
   "lat": 33.44,
   "lon": -94.04,
   "timezone": "America/Chicago",
   "timezone_offset": -18000,
   "daily": [
      {
         "dt": 1684951200,
         "sunrise": 1684926645,
         "sunset": 1684977332,
         "moonrise": 1684941060,
         "moonset": 1684905480,
         "moon_phase": 0.16,
         "summary": "Expect a day of partly cloudy with rain",
         "temp": {
            "day": 299.03,
            "min": 290.69,
            "max": 300.35,
            "night": 291.45,
            "eve": 297.51,
            "morn": 292.55
         },
         "feels_like": {
            "day": 299.21,
            "night": 291.37,
            "eve": 297.86,
            "morn": 292.87
         },
         "pressure": 1016,
         "humidity": 59,
         "dew_point": 290.48,
         "wind_speed": 3.98,
         "wind_deg": 76,
         "wind_gust": 8.92,
         "weather": [
            {
               "id": 500,
               "main": "Rain",
               "description": "light rain",
               "icon": "10d"
            }
         ],
         "clouds": 92,
         "pop": 0.47,
         "rain": 0.15,
         "uvi": 9.23
      },
      // Mais 2 dias...
   ]
}
```

### 4. Obter Alertas Meteorológicos

**Endpoint:** `GET /api/weather/alerts`

**Parâmetros de Consulta:**
- `lat` (obrigatório): Latitude da localização
- `lon` (obrigatório): Longitude da localização

**Resposta de Sucesso:**
- Código: 200 OK
- Corpo: Objeto JSON contendo os alertas meteorológicos

**Exemplo de Requisição:**
```
GET /api/weather/alerts?lat=33.44&lon=-94.04
```

**Exemplo de Resposta:**
```json
{
   "lat": 33.44,
   "lon": -94.04,
   "timezone": "America/Chicago",
   "timezone_offset": -18000,
   "alerts": [
      {
         "sender_name": "NWS Philadelphia - Mount Holly (New Jersey, Delaware, Southeastern Pennsylvania)",
         "event": "Small Craft Advisory",
         "start": 1684952747,
         "end": 1684988747,
         "description": "...SMALL CRAFT ADVISORY REMAINS IN EFFECT FROM 5 PM THIS\nAFTERNOON TO 3 AM EST FRIDAY...\n* WHAT...North winds 15 to 20 kt with gusts up to 25 kt and seas\n3 to 5 ft expected.\n* WHERE...Coastal waters from Little Egg Inlet to Great Egg\nInlet NJ out 20 nm, Coastal waters from Great Egg Inlet to\nCape May NJ out 20 nm and Coastal waters from Manasquan Inlet\nto Little Egg Inlet NJ out 20 nm.\n* WHEN...From 5 PM this afternoon to 3 AM EST Friday.\n* IMPACTS...Conditions will be hazardous to small craft.",
         "tags": []
      }
   ]
}
```

### 5. Atualizar Dados Meteorológicos (Administrador)

**Endpoint:** `POST /api/admin/weather/update`

**Cabeçalhos:**
- `Content-Type: application/json`
- `Authorization: Bearer {token}`

**Corpo da Requisição:**
```json
{
   "lat": 33.44,
   "lon": -94.04,
   "data": {
      // Dados meteorológicos completos
   }
}
```

**Resposta de Sucesso:**
- Código: 200 OK
- Corpo: Mensagem de confirmação

**Exemplo de Resposta:**
```json
{
   "message": "Dados meteorológicos atualizados com sucesso",
   "timestamp": 1684929490
}
```

## Códigos de Erro

- **400 Bad Request**: Parâmetros inválidos ou ausentes
- **401 Unauthorized**: Autenticação necessária
- **403 Forbidden**: Acesso negado
- **404 Not Found**: Recurso não encontrado
- **500 Internal Server Error**: Erro interno do servidor

## Paginação

Para endpoints que retornam grandes conjuntos de dados, a paginação será implementada usando os seguintes parâmetros:

- `page`: Número da página (começando em 0)
- `size`: Tamanho da página (número de itens por página)

**Exemplo:**
```
GET /api/weather/history?lat=33.44&lon=-94.04&page=0&size=10
```

## Filtros

Alguns endpoints suportarão filtros adicionais para refinar os resultados:

- `from`: Data de início (timestamp Unix)
- `to`: Data de fim (timestamp Unix)
- `units`: Unidade de medida (metric, imperial, standard)

**Exemplo:**
```
GET /api/weather/history?lat=33.44&lon=-94.04&from=1684900000&to=1684990000&units=metric
```

Esta documentação fornece uma visão geral dos endpoints da API de Dados Meteorológicos, incluindo exemplos de requisições e respostas, códigos de erro e opções de paginação e filtros.

