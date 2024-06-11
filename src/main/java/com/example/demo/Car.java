package com.example.demo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component // IoC의 대상으로 설정
@Setter
@Getter
@ToString
public class Car {
    int tire;
    String model;
    public void run() {
        System.out.println("Car run!!!");
    }
}