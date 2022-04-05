package com.employementmanagementsystem.mvc.dto;

/**
 * Created by Kelzang Ugyen Dorji on 4/5/2022.
 */
public class UserDto {
    private String userId;
    private String password;

    public UserDto() {
    }

    public UserDto(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
