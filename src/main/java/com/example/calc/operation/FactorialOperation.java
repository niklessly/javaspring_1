package com.example.calc.operation;

import org.springframework.stereotype.Component;

@Component("factorialOperation")
public class FactorialOperation implements Operation {
    @Override
    public String key() {
        return "!";
    }

    @Override
    public int arity() {
        return 1;
    }

    @Override
    public double apply(double... args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Операция ! требует 1 аргумент");
        }

        double value = args[0];
        if (value < 0) {
            throw new IllegalArgumentException("Факториал от отрицательного числа не определен");
        }
        if (value != Math.floor(value)) {
            throw new IllegalArgumentException("Факториал считается только для целых чисел");
        }

        int n = (int) value;
        double result = 1.0;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
