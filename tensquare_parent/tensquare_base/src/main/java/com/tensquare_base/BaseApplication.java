package com.tensquare_base;

import com.tensquare_common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }
    @Bean
    public IdWorker getIdWorker(){
        return new IdWorker(1,1);
    }
}
