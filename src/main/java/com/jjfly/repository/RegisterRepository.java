package com.jjfly.repository;

import com.jjfly.common.FormatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 * Created by Prac on 6/5/2016.
 */
@Repository
public class RegisterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(String username, String password, String tel) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String encryptedPassword = encoder.encodePassword(password, null);
        String sql = "insert into user values(?, ?, ?)";
        jdbcTemplate.update(sql, tel, username, encryptedPassword);
    }

    public FormatResponse register(String username, String password, String tel) {
        addUser(username, password, tel);
        return new FormatResponse(200, "OK", "Success");
    }

}
