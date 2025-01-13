package com.xbc.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevopsApplication {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(DevopsApplication.class, args);
        System.out.println(" devops server run time is " + (System.currentTimeMillis() - start) +" ms ");

    }

}
