package com.example.calc.config;

import com.example.calc.io.ConsoleIoService;
import com.example.calc.io.IoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.calc")
public class AppConfig {
    @Bean
    public IoService ioService() {
        return new ConsoleIoService();
    }
}
