package com.authorization.ems.dao;

import com.authorization.ems.pojo.UserEmp;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserEmpRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserEmp userEmp = new UserEmp();
//        userEmp.setId(rs.getLong("id"));
        userEmp.setUsername(rs.getString("username"));
        userEmp.setEmail(rs.getString("email"));
        userEmp.setPassword(rs.getString("password"));
        return userEmp;
    }
}
