package com.emmarock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
public class App 
{
    private static final Logger log = LoggerFactory.getLogger(App.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    public static void main( String[] args )
    {
        log.error("The time is now {}", dateFormat.format(new Date()));
        SpringApplication.run(App.class, args);
    }
}
