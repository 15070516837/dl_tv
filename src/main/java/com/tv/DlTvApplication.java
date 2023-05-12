package com.tv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Json
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DlTvApplication {

    public static void main(String[] args) {
        SpringApplication.run(DlTvApplication.class, args);
    }
}
