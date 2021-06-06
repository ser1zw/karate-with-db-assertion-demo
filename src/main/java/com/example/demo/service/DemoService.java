package com.example.demo.service;

import com.example.demo.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DemoService {
    @Autowired
    DemoDao demoDao;

    public List<Map<String, Object>> findAll() {
        return demoDao.findAll();
    }

    public int add(String message) {
        return demoDao.insertMessage(message);
    }
}
