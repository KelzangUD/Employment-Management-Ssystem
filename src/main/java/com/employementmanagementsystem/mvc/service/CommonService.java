package com.employementmanagementsystem.mvc.service;

import com.employementmanagementsystem.mvc.dao.UserDao;
import com.employementmanagementsystem.mvc.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kelzang Ugyen Dorji on 2/23/2022.
 */
@Service
public class CommonService {
    @Autowired
    UserDao userDao;
    public String validateUser(UserDto userDto){
        String role = userDao.loginValidation(userDto);
        return role;
    }
}
