package com.example.musicmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class MusicManagerApplication {
     @RequestMapping("index")
    public static void main(String[] args)  {
         SpringApplication.run(MusicManagerApplication.class, args);

    }


}
