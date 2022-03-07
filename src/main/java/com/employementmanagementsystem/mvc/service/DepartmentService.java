package com.employementmanagementsystem.mvc.service;

import com.employementmanagementsystem.mvc.dao.DepartmentDao;
import com.employementmanagementsystem.mvc.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kelzang Ugyen Dorji on 3/1/2022.
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;
    public List<DepartmentDto> getDepartmentList(DepartmentDto departmentDto){
        List<DepartmentDto> departmentDtos = departmentDao.getDepartmentList(departmentDto);
        return departmentDtos;
    }
}
