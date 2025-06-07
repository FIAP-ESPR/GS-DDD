/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.service.impl;

import com.weather.api.exception.ResourceNotFoundException;
import com.weather.api.factory.WeatherDTOFactory;
import com.weather.api.model.dto.*;
import com.weather.api.model.entity.*;
import com.weather.api.repository.*;
import com.weather.api.service.WeatherService;
import com.weather.api.singleton.WeatherDataCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementação do serviço de dados meteorológicos.
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private final LocationRepository locationRepository;
    private final CurrentWeatherRepository currentWeatherRepository;
    private final MinutelyWeatherRepository minutelyWeatherRepository;
    private final HourlyWeatherRepository hourlyWeatherRepository;
    private final DailyWeatherRepository dailyWeatherRepository;
    private final WeatherAlertRepository weatherAlertRepository;
    private final WeatherDataCache weatherDataCache;

    @Autowired
    public WeatherServiceImpl(LocationRepository locationRepository,
                              CurrentWeatherRepository currentWeatherRepository,
                              MinutelyWeatherRepository minutelyWeatherRepository,
                              HourlyWeatherRepository hourlyWeatherRepository,
                              DailyWeatherRepository dailyWeatherRepository,
                              WeatherAlertRepository weatherAlertRepository,
                              WeatherDataCache weatherDataCache) {
        this.locationRepository = locationRepository;
        this.currentWeatherRepository = currentWeatherRepository;
        this.minutelyWeatherRepository = minutelyWeatherRepository;
        this.hourlyWeatherRepository = hourlyWeatherRepository;
        this.dailyWeatherRepository = dailyWeatherRepository;
        this.weatherAlertRepository = weatherAlertRepository;
        this.weatherDataCache = weatherDataCache;
    }

    @Override
    public WeatherDataDTO getWeatherData(Double lat, Double lon) {
        Location location = locationRepository.findByLatitudeAndLongitude(lat, lon);

        if (location == null) {
            throw new ResourceNotFoundException("Dados meteorológicos não encontrados para a localização fornecida.");
        }

        CurrentWeatherData current = currentWeatherRepository.findByLocation(location).orElse(null);
        List<MinutelyWeatherData> minutely = minutelyWeatherRepository.findByLocation(location);
        List<HourlyWeatherData> hourly = hourlyWeatherRepository.findByLocation(location);
        List<DailyWeatherData> daily = dailyWeatherRepository.findByLocation(location);
        List<WeatherAlert> alerts = weatherAlertRepository.findByLocation(location);

        return WeatherDTOFactory.createWeatherDataDTO(current, minutely, hourly, daily, alerts);
    }

    @Override
    public CurrentWeatherDTO getCurrentWeather(Double lat, Double lon) {
        Location location = locationRepository.findByLatitudeAndLongitude(lat, lon);
        if (location == null) {
            throw new ResourceNotFoundException("Localização não encontrada.");
        }
        CurrentWeatherData current = currentWeatherRepository.findByLocation(location)
                .orElseThrow(() -> new ResourceNotFoundException("Dados meteorológicos atuais não encontrados para a localização fornecida."));
        return WeatherDTOFactory.createCurrentWeatherDTO(current);
    }

    @Override
    public List<MinutelyWeatherDTO> getMinutelyWeather(Double lat, Double lon) {
        Location location = locationRepository.findByLatitudeAndLongitude(lat, lon);
        if (location == null) {
            throw new ResourceNotFoundException("Localização não encontrada.");
        }
        List<MinutelyWeatherData> minutely = minutelyWeatherRepository.findByLocation(location);
        if (minutely.isEmpty()) {
            throw new ResourceNotFoundException("Dados meteorológicos por minuto não encontrados para a localização fornecida.");
        }
        return minutely.stream()
                .map(WeatherDTOFactory::createMinutelyWeatherDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<HourlyWeatherDTO> getHourlyWeather(Double lat, Double lon) {
        Location location = locationRepository.findByLatitudeAndLongitude(lat, lon);
        if (location == null) {
            throw new ResourceNotFoundException("Localização não encontrada.");
        }
        List<HourlyWeatherData> hourly = hourlyWeatherRepository.findByLocation(location);
        if (hourly.isEmpty()) {
            throw new ResourceNotFoundException("Dados meteorológicos por hora não encontrados para a localização fornecida.");
        }
        return hourly.stream()
                .map(WeatherDTOFactory::createHourlyWeatherDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DailyWeatherDTO> getDailyWeather(Double lat, Double lon) {
        Location location = locationRepository.findByLatitudeAndLongitude(lat, lon);
        if (location == null) {
            throw new ResourceNotFoundException("Localização não encontrada.");
        }
        List<DailyWeatherData> daily = dailyWeatherRepository.findByLocation(location);
        if (daily.isEmpty()) {
            throw new ResourceNotFoundException("Dados meteorológicos diários não encontrados para a localização fornecida.");
        }
        return daily.stream()
                .map(WeatherDTOFactory::createDailyWeatherDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<WeatherAlertDTO> getWeatherAlerts(Double lat, Double lon) {
        Location location = locationRepository.findByLatitudeAndLongitude(lat, lon);
        if (location == null) {
            throw new ResourceNotFoundException("Localização não encontrada.");
        }
        List<WeatherAlert> alerts = weatherAlertRepository.findByLocation(location);
        if (alerts.isEmpty()) {
            throw new ResourceNotFoundException("Alertas meteorológicos não encontrados para a localização fornecida.");
        }
        return alerts.stream()
                .map(WeatherDTOFactory::createWeatherAlertDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void saveLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void saveCurrentWeatherData(CurrentWeatherData currentWeatherData) {
        currentWeatherRepository.save(currentWeatherData);
    }

    @Override
    public void saveMinutelyWeatherData(MinutelyWeatherData minutelyWeatherData) {
        minutelyWeatherRepository.save(minutelyWeatherData);
    }

    @Override
    public void saveHourlyWeatherData(HourlyWeatherData hourlyWeatherData) {
        hourlyWeatherRepository.save(hourlyWeatherData);
    }

    @Override
    public void saveDailyWeatherData(DailyWeatherData dailyWeatherData) {
        dailyWeatherRepository.save(dailyWeatherData);
    }

    @Override
    public void saveWeatherAlert(WeatherAlert weatherAlert) {
        weatherAlertRepository.save(weatherAlert);
    }

    @Override
    public void updateWeatherData(Double lat, Double lon, WeatherDataDTO weatherDataDTO) {
        // Implementação da lógica de atualização
        // Por exemplo, encontrar a localização, atualizar os dados existentes ou criar novos
        Location location = locationRepository.findByLatitudeAndLongitude(lat, lon);
        if (location == null) {
            throw new ResourceNotFoundException("Localização não encontrada para atualização.");
        }

        // Exemplo de atualização de dados atuais
        CurrentWeatherData current = currentWeatherRepository.findByLocation(location).orElse(null);
        if (current != null && weatherDataDTO.getCurrent() != null) {
            // Atualizar campos do 'current' com base em weatherDataDTO.getCurrent()
            current.setTemp(weatherDataDTO.getCurrent().getTemp());
            current.setFeelsLike(weatherDataDTO.getCurrent().getFeels_like());
            // ... outros campos
            currentWeatherRepository.save(current);
        } else if (current == null && weatherDataDTO.getCurrent() != null) {
            // Criar novo CurrentWeatherData se não existir
            CurrentWeatherData newCurrent = new CurrentWeatherData();
            newCurrent.setLocation(location);
            newCurrent.setDt(weatherDataDTO.getCurrent().getDt());
            newCurrent.setTemp(weatherDataDTO.getCurrent().getTemp());
            newCurrent.setFeelsLike(weatherDataDTO.getCurrent().getFeels_like());
            // ... outros campos
            currentWeatherRepository.save(newCurrent);
        }

        // Lógica similar para minutely, hourly, daily e alerts
    }
}

