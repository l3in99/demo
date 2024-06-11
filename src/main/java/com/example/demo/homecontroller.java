package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homecontroller {
    @Autowired JdbcTemplate jt;

    @RequestMapping("/")
    public String home() {
        List<Map<String, Object>> list = jt.queryForList("select * from dept");
        System.out.println(list);
        return "home";
    }
}
