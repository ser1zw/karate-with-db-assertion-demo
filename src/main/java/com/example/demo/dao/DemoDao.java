package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DemoDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> findAll() {
        return jdbcTemplate.queryForList("select id, message from messages order by id");
    }

    public int insertMessage(String message) {
        return jdbcTemplate.update("insert into messages (message) values (?)", message);
    }
}
