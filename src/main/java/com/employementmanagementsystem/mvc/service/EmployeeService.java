package com.employementmanagementsystem.mvc.service;

import com.employementmanagementsystem.mvc.dao.EmployeeDao;
import com.employementmanagementsystem.mvc.dto.CommonDto;
import com.employementmanagementsystem.mvc.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kelzang Ugyen Dorji on 3/1/2022.
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;
    public List<EmployeeDto> getEmployeeList(EmployeeDto employeeDto){
        return employeeDao.getEmployeeList(employeeDto);
    }
    public String addNewEmployee(EmployeeDto employeeDto){
        String result = employeeDao.addNewEmployee(employeeDto);
        return result;
    }
    public EmployeeDto getEmployeeDetail(Integer id){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto = (EmployeeDto) employeeDao.getEmployeeDetail(id);
        return  employeeDto;
    }
    public String editDetails(EmployeeDto employeeDto){
        String result = employeeDao.editDetail(employeeDto);
        return result;
    }
    public String deleteEmployee(Integer id){
        String result = employeeDao.deleteEmployee(id);
        return result;
    }
    public Integer getCount(){
        Integer count = employeeDao.getEmployeeCount();
        return count;
    }
}
