package com.employementmanagementsystem.mvc.service;

import com.employementmanagementsystem.mvc.dto.ApiDto;
import com.employementmanagementsystem.mvc.dto.weather.CurrentWeatherDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URL;

/**
 * Created by Kelzang Ugyen Dorji on 3/5/2022.
 */
@Service
public class WeatherService {
    String appid="01830b1f275e89f0d8ddb2a7376ca39f";
    public ApiDto getCurrentWeatherCondition(String location){
        CurrentWeatherDto weatherDto = new CurrentWeatherDto();
        ApiDto apiDto = new ApiDto();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+location+"&appid="+appid);

            weatherDto = objectMapper.readValue(url, CurrentWeatherDto.class);
            apiDto.setLon(weatherDto.getCoord().get(0).getLon());
            apiDto.setLat(weatherDto.getCoord().get(0).getLat());
            apiDto.setWeather(weatherDto.getWeather().get(0).getMain());
            apiDto.setDescription(weatherDto.getWeather().get(0).getDescription());
            apiDto.setTemp(weatherDto.getMain().get(0).getTemp()-273);
            apiDto.setMaxTemp(weatherDto.getMain().get(0).getTemp_max()-273);
            apiDto.setMinTemp(weatherDto.getMain().get(0).getTemp_min()-273);
            apiDto.setHumidity(weatherDto.getMain().get(0).getHumidity());
            apiDto.setPressure(weatherDto.getMain().get(0).getPressure());
            apiDto.setWindSpeed(weatherDto.getWind().get(0).getSpeed());
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex);
        }
        return apiDto;
    }
}
