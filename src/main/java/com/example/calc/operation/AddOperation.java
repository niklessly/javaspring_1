package com.example.calc.operation;

import org.springframework.stereotype.Component;

@Component("addOperation")
public class AddOperation implements Operation {
    @Override
    public String key() {
        return "+";
    }

    @Override
    public int arity() {
        return 2;
    }

    @Override
    public double apply(double... args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Операция + требует 2 аргумента");
        }
        return args[0] + args[1];
    }
}
