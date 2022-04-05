package com.employementmanagementsystem.mvc.service;

import com.employementmanagementsystem.mvc.dao.UserDao;
import com.employementmanagementsystem.mvc.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kelzang Ugyen Dorji on 4/5/2022.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public String getUserDetail(UserDto userDto){
        String userType = userDao.getUserDetail(userDto);
        return userType;
    }
}
