package com.example.calc;

import com.example.calc.runner.CalculatorRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("application-context.xml")) {
            CalculatorRunner runner = context.getBean(CalculatorRunner.class);
            runner.run();
        }
    }
}
