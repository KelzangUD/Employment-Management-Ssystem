package com.employementmanagementsystem.mvc.dto.weather;

/**
 * Created by Kelzang Ugyen Dorji on 3/5/2022.
 */
public class WeatherDto {
    private Integer id;
    private String main;
    private String description;

    public WeatherDto() {
    }

    public WeatherDto(Integer id, String main, String description) {
        this.id = id;
        this.main = main;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
