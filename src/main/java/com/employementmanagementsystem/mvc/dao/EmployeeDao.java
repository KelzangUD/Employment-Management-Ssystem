package com.employementmanagementsystem.mvc.dao;

import com.employementmanagementsystem.mvc.baseDao.CommonBaseDao;
import com.employementmanagementsystem.mvc.dto.CommonDto;
import com.employementmanagementsystem.mvc.dto.EmployeeDto;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelzang Ugyen Dorji on 3/1/2022.
 */
@Repository
public class EmployeeDao extends CommonBaseDao {
    @Transactional
    public List<EmployeeDto> getEmployeeList(EmployeeDto employeeDto){
        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
        try{
            sqlQuery = properties.getProperty("Employee.getEmployeeList");
            employeeDtos = (List<EmployeeDto>) hibernateQuery(sqlQuery, EmployeeDto.class).list();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return  employeeDtos;
    }
    @Transactional
    public String addNewEmployee(EmployeeDto employeeDto){
        String result ="";
        try {
            String sql = properties.getProperty("Employee.addNewEmployee");
            Query query = sqlQuery(sql).setParameter(1, employeeDto.getFirstName())
                    .setParameter(2, employeeDto.getLastName())
                    .setParameter(3, employeeDto.getDob())
                    .setParameter(4, employeeDto.getEmail())
                    .setParameter(5, employeeDto.getDepartmentId());
            int queryResult = query.executeUpdate();
            result = (queryResult>0)?"SUCCESS":"FAILED";
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return result;
    }
    @Transactional
    public EmployeeDto getEmployeeDetail(Integer id){
        EmployeeDto employeeDtos = new EmployeeDto();
//        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
        try{
            String sql = properties.getProperty("Employee.getEmployeeDetail");
            Query query = sqlQuery(sql, EmployeeDto.class)
                    .setParameter(1, id);
            employeeDtos = (EmployeeDto) query.list().get(0);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return employeeDtos;
    }
    @Transactional
    public String editDetail(EmployeeDto employeeDto){
        String result="";
        try{
            String sql = properties.getProperty("Employee.editDetail");
            Query query = sqlQuery(sql).setParameter(1, employeeDto.getFirstName())
                    .setParameter(2, employeeDto.getLastName())
                    .setParameter(3, employeeDto.getDob())
                    .setParameter(4, employeeDto.getEmail())
                    .setParameter(5, employeeDto.getDepartmentId())
                    .setParameter(6, employeeDto.getId());
            int queryResult = query.executeUpdate();
            result = (queryResult>0)?"SUCCESS":"FAILED";
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return result;
    }
    @Transactional
    public String deleteEmployee(Integer id){
        String result="";
        try{
            String sql = properties.getProperty("Employee.deleteEmployee");
            Query query = sqlQuery(sql).setParameter(1, id);
            int sqlResult = query.executeUpdate();
            result = (sqlResult>0)?"SUCCESS":"FAILED";
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return result;
    }
    @Transactional
    public Integer getEmployeeCount(){
        String count ="";
        CommonDto commonDto = new CommonDto();
        try{
            sqlQuery = properties.getProperty("Employee.countEmployee");
            commonDto = (CommonDto) hibernateQuery(sqlQuery, CommonDto.class).getSingleResult();
            System.out.print(commonDto.getEmpCount());
            count = String.valueOf(commonDto.getEmpCount());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return Integer.valueOf(count);

    }
}
