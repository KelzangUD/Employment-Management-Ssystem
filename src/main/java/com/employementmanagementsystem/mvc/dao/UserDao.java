package com.employementmanagementsystem.mvc.dao;

import com.employementmanagementsystem.mvc.baseDao.CommonBaseDao;
import com.employementmanagementsystem.mvc.dto.UserDto;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelzang Ugyen Dorji on 4/5/2022.
 */
@Repository
public class UserDao extends CommonBaseDao {
    @Transactional
    public String getUserDetail(UserDto userDto){
        String userType="";
        try{
            String sql = "SELECT CAST(a.user_id AS CHAR) userId, a.password password FROM empdb_login_master a WHERE a.user_id = ? AND a.password=?;";
            Query query = sqlQuery(sql, UserDto.class).setParameter(1, userDto.getUserId()).setParameter(2, userDto.getPassword());
            userType = query.list().size()>0?"Valid":"Invlaid";

        }
        catch (Exception ex){
            System.out.println(ex + " Exception in getUserDetail");
        }
        return userType;
    }
}
