package com.example.demo;

import org.springframework.stereotype.Component;

@Component // IoC의 대상으로 설정
public class Car {
    public void run() {
        System.out.println("Car run!!!");
    }
}
