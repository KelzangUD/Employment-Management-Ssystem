package com.employementmanagementsystem.mvc.dao;

import com.employementmanagementsystem.mvc.baseDao.CommonBaseDao;
import com.employementmanagementsystem.mvc.dto.UserDto;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kelzang Ugyen Dorji on 2/23/2022.
 */
@Repository
public class UserDao extends CommonBaseDao {
    @Transactional
    public String loginValidation(UserDto userDto){
        String role="";
        try{
            String sql = properties.getProperty("user");
            Query query = sqlQuery(sql).setParameter(1, userDto.getUserId()).setParameter(2, userDto.getPassword());
            role=((query.list().size()>0)?String.valueOf(query.list().get(0)):"Invalid User");

        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return role;
    }
}
