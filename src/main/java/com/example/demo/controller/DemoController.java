package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("/")
    @ResponseBody
    public List<Map<String, Object>> findAll() {
        return demoService.findAll();
    }

    @PostMapping("/")
    @ResponseBody
    public Map<String, Object> post(@RequestBody Map<String, String> message) {
        var result = demoService.add(message.get("message"));
        return Map.of("result", "success");
    }
}
