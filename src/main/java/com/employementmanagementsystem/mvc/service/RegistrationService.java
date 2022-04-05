package com.employementmanagementsystem.mvc.service;

import com.employementmanagementsystem.mvc.dao.RegistrationDao;
import com.employementmanagementsystem.mvc.dto.RegistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kelzang Ugyen Dorji on 4/5/2022.
 */
@Service
public class RegistrationService {
    @Autowired
    RegistrationDao registrationDao;
    public String getRegistration(RegistDto registDto){
        String regist = registrationDao.getRes(registDto);

        return regist;
    }
}
