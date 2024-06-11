package com.example.demo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.component.Bean3;
import com.example.demo.component.ImageUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class homecontroller {
    @Autowired JdbcTemplate jt;
    @Autowired String bean1;
    @Autowired Game game;
    @Autowired Bean3 bean3;
    @Autowired ImageUtil iu;
    @RequestMapping("/")
    public String home() {
        try {
            iu.save("http://ggoreb.com/images/luffy.jpg");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.info(game.play());
        log.info(bean1);
        log.info(bean3.run());
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
