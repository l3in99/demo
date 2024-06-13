package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.component.Bean3;
import com.example.demo.component.ImageUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class homecontroller {

    // html로 출력
    @GetMapping("/test/html")
    public String testHtml() {
        return "home";
    }

    @GetMapping("/test/html2")
    @ResponseBody
    public String testHtml2() {
        return "home";
    }

    // json 출력
    @GetMapping("/test/json")
    @ResponseBody
    public Map testJson() {
        Map map = new HashMap();
        map.put("key1", true);
        map.put("key2", false);
        map.put("key3", "no");
        return map;
    }
    @GetMapping("/test/json2")
    @ResponseBody
    public List testJson2() {
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("key1", true);
        map.put("key2", false);
        map.put("key3", "no");
        list.add(map);
        return list;
    }
    @GetMapping("/test/json3")
    @ResponseBody
    public Car testJson3() {
        Car car = new Car();
        car.setTire(4);
        car.setModel("EV6");
        return car;
    }

    @Autowired JdbcTemplate jt;
    @GetMapping("/test/emp")
    @ResponseBody
    public List<Map<String, Object>> testEmp() {
        List<Map<String, Object>> list = jt.queryForList("select * from emp");
        return list;
    }

    @Autowired JdbcTemplate jt2;
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
