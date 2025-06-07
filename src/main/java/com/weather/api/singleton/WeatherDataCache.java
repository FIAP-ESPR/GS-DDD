/**
 * Projeto: API de Dados Meteorológicos
 * Integrantes do Grupo:
 * - Vinicius Silva - RM553240
 * - Victor Didoff - RM552965
 * - Matheus Zottis - RM94119
 */

package com.weather.api.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.weather.api.model.dto.WeatherDataDTO;

/**
 * Implementação do padrão Singleton para cache de dados meteorológicos.
 * Esta classe utiliza o padrão Singleton para garantir que exista apenas uma instância
 * do cache de dados meteorológicos em toda a aplicação.
 */
@Component
public class WeatherDataCache {
    
    // Instância única da classe
    private static WeatherDataCache instance;
    
    // Cache de dados meteorológicos usando ConcurrentHashMap para thread-safety
    private final Map<String, WeatherDataDTO> cache = new ConcurrentHashMap<>();
    
    /**
     * Construtor privado para evitar instanciação direta.
     * Parte do padrão Singleton.
     */
    private WeatherDataCache() {
        // Construtor privado para evitar instanciação direta
    }
    
    /**
     * Método chamado após a inicialização do bean.
     * Configura a instância estática para acesso global.
     */
    @PostConstruct
    private void init() {
        instance = this;
    }
    
    /**
     * Método estático para obter a instância única do cache.
     * Parte do padrão Singleton.
     *
     * @return Instância única do cache
     */
    public static WeatherDataCache getInstance() {
        return instance;
    }
    
    /**
     * Obtém dados meteorológicos do cache.
     *
     * @param key Chave do cache (geralmente latitude:longitude)
     * @return Dados meteorológicos ou null se não encontrados
     */
    public WeatherDataDTO get(String key) {
        return cache.get(key);
    }
    
    /**
     * Armazena dados meteorológicos no cache.
     *
     * @param key  Chave do cache (geralmente latitude:longitude)
     * @param data Dados meteorológicos
     */
    public void put(String key, WeatherDataDTO data) {
        cache.put(key, data);
    }
    
    /**
     * Verifica se o cache contém uma chave.
     *
     * @param key Chave do cache
     * @return true se o cache contém a chave, false caso contrário
     */
    public boolean contains(String key) {
        return cache.containsKey(key);
    }
    
    /**
     * Remove dados meteorológicos do cache.
     *
     * @param key Chave do cache
     * @return Dados meteorológicos removidos ou null se não encontrados
     */
    public WeatherDataDTO remove(String key) {
        return cache.remove(key);
    }
    
    /**
     * Limpa todo o cache.
     */
    public void clear() {
        cache.clear();
    }
    
    /**
     * Obtém o tamanho do cache.
     *
     * @return Número de entradas no cache
     */
    public int size() {
        return cache.size();
    }
}

