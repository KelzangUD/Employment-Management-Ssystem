package com.employementmanagementsystem.mvc.dto.weather;

/**
 * Created by Kelzang Ugyen Dorji on 3/5/2022.
 */
public class WindDto {
    private Integer speed;
    private Integer deg;
    private Integer gust;

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Integer getGust() {
        return gust;
    }

    public void setGust(Integer gust) {
        this.gust = gust;
    }
}
