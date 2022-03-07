package com.employementmanagementsystem.mvc.dao;

import com.employementmanagementsystem.mvc.baseDao.CommonBaseDao;
import com.employementmanagementsystem.mvc.dto.DepartmentDto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelzang Ugyen Dorji on 3/1/2022.
 */
@Repository
public class DepartmentDao extends CommonBaseDao{
    @Transactional
    public List<DepartmentDto> getDepartmentList(DepartmentDto departmentDto){
        List<DepartmentDto> departmentDto1 = new ArrayList<DepartmentDto>();
        try{
            sqlQuery = properties.getProperty("Department.getDepartmentList");
            departmentDto1 = (List<DepartmentDto>) hibernateQuery(sqlQuery, DepartmentDto.class).list();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return departmentDto1;
    }
}
