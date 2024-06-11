package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class homecontroller {
    @Autowired JdbcTemplate jt;

    @RequestMapping("/")
    public String home() {
        Car car = new Car();
        car.setTire(3);
        car.setModel("KIA");
        log.info(car.toString());
        List<Map<String, Object>> list = jt.queryForList("select * from dept");
        System.out.println(list);
        log.info(list.toString());
        return "home";
    }
}
