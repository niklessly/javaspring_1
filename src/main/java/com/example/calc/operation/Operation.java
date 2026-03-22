package com.example.calc.operation;

public interface Operation {
    String key();

    int arity();

    double apply(double... args);
}
