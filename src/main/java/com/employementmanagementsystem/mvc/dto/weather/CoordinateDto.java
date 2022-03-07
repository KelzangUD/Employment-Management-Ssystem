package com.employementmanagementsystem.mvc.dto.weather;

/**
 * Created by Kelzang Ugyen Dorji on 3/5/2022.
 */
public class CoordinateDto {
    private Integer lon;
    private Integer lat;

    public CoordinateDto() {
    }

    public CoordinateDto(Integer lon, Integer lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Integer getLon() {
        return lon;
    }

    public void setLon(Integer lon) {
        this.lon = lon;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }
}
