package com.employementmanagementsystem.mvc.dto.weather;

import com.employementmanagementsystem.mvc.dto.MainDto;
import com.employementmanagementsystem.mvc.dto.weather.*;

import java.util.List;

/**
 * Created by Kelzang Ugyen Dorji on 3/5/2022.
 */
public class CurrentWeatherDto {
    private List<CoordinateDto> coord;
    private List<WeatherDto> weather;
    private String base;
    private List<MainDto> main;
    private Integer visibility;
    private List<WindDto> wind;
    private List<CloudsDto> clouds;
    private Integer dt;
    private List<SysDto> sys;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer cod;

    public List<CoordinateDto> getCoord() {
        return coord;
    }

    public void setCoord(List<CoordinateDto> coord) {
        this.coord = coord;
    }

    public List<WeatherDto> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public List<MainDto> getMain() {
        return main;
    }

    public void setMain(List<MainDto> main) {
        this.main = main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public List<WindDto> getWind() {
        return wind;
    }

    public void setWind(List<WindDto> wind) {
        this.wind = wind;
    }

    public List<CloudsDto> getClouds() {
        return clouds;
    }

    public void setClouds(List<CloudsDto> clouds) {
        this.clouds = clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public List<SysDto> getSys() {
        return sys;
    }

    public void setSys(List<SysDto> sys) {
        this.sys = sys;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }
}
