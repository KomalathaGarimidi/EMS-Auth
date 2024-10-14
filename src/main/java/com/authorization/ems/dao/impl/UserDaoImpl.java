package com.authorization.ems.dao.impl;

import com.authorization.ems.dao.UserDao;
import com.authorization.ems.dao.UserEmpRowMapper;
import com.authorization.ems.pojo.UserEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int saveUser(UserEmp userEmp) {

        System.out.println("JdbcTemplate || "+jdbcTemplate);

        String sql = "insert into users(username,password,email) values(?,?,?)";
        int result=jdbcTemplate.update(sql,userEmp.getUsername(),userEmp.getPassword(),userEmp.getEmail());

        System.out.println("successfully inserted");

        System.out.println("username || "+userEmp.getUsername());
        System.out.println("password || "+userEmp.getPassword());
        System.out.println("email || "+userEmp.getEmail());

        return result;

    }

    @Override
    public boolean existsByName(String username) {

        System.out.println("existsByName() invoked");
        String sql = "select count(*) from users where username=?";

        //returns how many members are ther with the given username
        int result = jdbcTemplate.queryForObject(sql,Integer.class,username);

        System.out.println("result from existsByName() || "+result);

        return result>0;
    }

    @Override
    public boolean existsByEmail(String email) {
        System.out.println("existsByEmail() invoked");
        String sql = "select email from users where email=?";

        int result = jdbcTemplate.queryForObject(sql,Integer.class,email);
        System.out.println("result from existsByEmil() ||"+result);

        return result>0;
    }

    @Override
    public Optional<UserEmp> findByUserName(String username) {
        System.out.println("findByUserName() invoked");

        String sql = "select * from users where username=?";
        List<UserEmp> result=jdbcTemplate.query(sql,new UserEmpRowMapper(),username);
        System.out.println("result from findByUserName || "+result);

        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    @Override
    public Optional<UserEmp> findByEmail(String email) {
        System.out.println("findByEmail() invoked");

        String sql = "select * from users where email=?";
        List<UserEmp> result=jdbcTemplate.query(sql,new UserEmpRowMapper(),email);
        System.out.println("result from findByEmail || "+result);

        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

}
//public String username;
//public String password;