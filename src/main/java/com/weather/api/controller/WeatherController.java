/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.controller;

import com.weather.api.model.dto.CurrentWeatherDTO;
import com.weather.api.model.dto.DailyWeatherDTO;
import com.weather.api.model.dto.HourlyWeatherDTO;
import com.weather.api.model.dto.MinutelyWeatherDTO;
import com.weather.api.model.dto.WeatherAlertDTO;
import com.weather.api.model.dto.WeatherDataDTO;
import com.weather.api.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para a API de dados meteorológicos.
 */
@RestController
@RequestMapping("/api/weather")
@Tag(name = "Dados Meteorológicos", description = "API para obtenção de dados meteorológicos por localização.")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Operation(summary = "Obtém todos os dados meteorológicos para uma localização",
            description = "Retorna dados meteorológicos atuais, por minuto, por hora, diários e alertas para uma dada latitude e longitude.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados meteorológicos encontrados",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = WeatherDataDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Dados meteorológicos não encontrados para a localização fornecida",
                    content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<WeatherDataDTO> getAllWeatherData(
            @Parameter(description = "Latitude da localização") @RequestParam Double lat,
            @Parameter(description = "Longitude da localização") @RequestParam Double lon) {
        WeatherDataDTO weatherData = weatherService.getWeatherData(lat, lon);
        return ResponseEntity.ok(weatherData);
    }

    @Operation(summary = "Obtém os dados meteorológicos atuais para uma localização",
            description = "Retorna os dados meteorológicos atuais para uma dada latitude e longitude.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados meteorológicos atuais encontrados",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CurrentWeatherDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Dados meteorológicos atuais não encontrados para a localização fornecida",
                    content = @Content)
    })
    @GetMapping("/current")
    public ResponseEntity<CurrentWeatherDTO> getCurrentWeather(
            @Parameter(description = "Latitude da localização") @RequestParam Double lat,
            @Parameter(description = "Longitude da localização") @RequestParam Double lon) {
        CurrentWeatherDTO currentWeather = weatherService.getCurrentWeather(lat, lon);
        return ResponseEntity.ok(currentWeather);
    }

    @Operation(summary = "Obtém os dados meteorológicos por minuto para uma localização",
            description = "Retorna os dados meteorológicos por minuto para uma dada latitude e longitude.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados meteorológicos por minuto encontrados",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MinutelyWeatherDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Dados meteorológicos por minuto não encontrados para a localização fornecida",
                    content = @Content)
    })
    @GetMapping("/minutely")
    public ResponseEntity<List<MinutelyWeatherDTO>> getMinutelyWeather(
            @Parameter(description = "Latitude da localização") @RequestParam Double lat,
            @Parameter(description = "Longitude da localização") @RequestParam Double lon) {
        List<MinutelyWeatherDTO> minutelyWeather = weatherService.getMinutelyWeather(lat, lon);
        return ResponseEntity.ok(minutelyWeather);
    }

    @Operation(summary = "Obtém os dados meteorológicos por hora para uma localização",
            description = "Retorna os dados meteorológicos por hora para uma dada latitude e longitude.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados meteorológicos por hora encontrados",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = HourlyWeatherDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Dados meteorológicos por hora não encontrados para a localização fornecida",
                    content = @Content)
    })
    @GetMapping("/hourly")
    public ResponseEntity<List<HourlyWeatherDTO>> getHourlyWeather(
            @Parameter(description = "Latitude da localização") @RequestParam Double lat,
            @Parameter(description = "Longitude da localização") @RequestParam Double lon) {
        List<HourlyWeatherDTO> hourlyWeather = weatherService.getHourlyWeather(lat, lon);
        return ResponseEntity.ok(hourlyWeather);
    }

    @Operation(summary = "Obtém os dados meteorológicos diários para uma localização",
            description = "Retorna os dados meteorológicos diários para uma dada latitude e longitude.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados meteorológicos diários encontrados",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DailyWeatherDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Dados meteorológicos diários não encontrados para a localização fornecida",
                    content = @Content)
    })
    @GetMapping("/daily")
    public ResponseEntity<List<DailyWeatherDTO>> getDailyWeather(
            @Parameter(description = "Latitude da localização") @RequestParam Double lat,
            @Parameter(description = "Longitude da localização") @RequestParam Double lon) {
        List<DailyWeatherDTO> dailyWeather = weatherService.getDailyWeather(lat, lon);
        return ResponseEntity.ok(dailyWeather);
    }

    @Operation(summary = "Obtém os alertas meteorológicos para uma localização",
            description = "Retorna os alertas meteorológicos para uma dada latitude e longitude.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alertas meteorológicos encontrados",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = WeatherAlertDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Alertas meteorológicos não encontrados para a localização fornecida",
                    content = @Content)
    })
    @GetMapping("/alerts")
    public ResponseEntity<List<WeatherAlertDTO>> getWeatherAlerts(
            @Parameter(description = "Latitude da localização") @RequestParam Double lat,
            @Parameter(description = "Longitude da localização") @RequestParam Double lon) {
        List<WeatherAlertDTO> weatherAlerts = weatherService.getWeatherAlerts(lat, lon);
        return ResponseEntity.ok(weatherAlerts);
    }

    @Operation(summary = "Atualiza os dados meteorológicos para uma localização",
            description = "Atualiza os dados meteorológicos (atuais, por minuto, por hora, diários e alertas) para uma dada latitude e longitude.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados meteorológicos atualizados com sucesso",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Localização não encontrada para atualização",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Requisição inválida",
                    content = @Content)
    })
    @PutMapping("/update")
    public ResponseEntity<Void> updateWeatherData(
            @Parameter(description = "Latitude da localização") @RequestParam Double lat,
            @Parameter(description = "Longitude da localização") @RequestParam Double lon,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados meteorológicos a serem atualizados",
                    required = true, content = @Content(schema = @Schema(implementation = WeatherDataDTO.class)))
            @RequestBody WeatherDataDTO weatherDataDTO) {
        weatherService.updateWeatherData(lat, lon, weatherDataDTO);
        return ResponseEntity.ok().build();
    }
}

