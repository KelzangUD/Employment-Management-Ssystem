package com.employementmanagementsystem.mvc.dao;

import com.employementmanagementsystem.mvc.baseDao.CommonBaseDao;
import com.employementmanagementsystem.mvc.dto.RegistDto;
import com.employementmanagementsystem.mvc.dto.UserDto;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kelzang Ugyen Dorji on 4/5/2022.
 */
@Repository
public class RegistrationDao extends CommonBaseDao {
    @Transactional
    public String getRes(RegistDto registDto){
        String userType="";
        try{
            String sql = "INSERT INTO empdb_employees (first_name, last_name, dob, email) VALUES(?,?,?,?)";
            Query query = sqlQuery(sql, RegistDto.class)
                    .setParameter(1, registDto.getFirstName())
                    .setParameter(2, registDto.getLastName())
                    .setParameter(3, registDto.getDob())
                    .setParameter(4, registDto.getEmail());
            userType = query.list().size()>0?"Valid":"Invlaid";

        }
        catch (Exception ex){
            System.out.println(ex + " Exception in getUserDetail");
        }
        return userType;
    }
}
