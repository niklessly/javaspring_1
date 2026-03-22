package com.example.calc.runner;

import com.example.calc.io.IoService;
import com.example.calc.navigator.OperationNavigator;
import com.example.calc.operation.Operation;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CalculatorRunner {
    private final IoService ioService;
    private final OperationNavigator operationNavigator;

    public CalculatorRunner(IoService ioService, OperationNavigator operationNavigator) {
        this.ioService = ioService;
        this.operationNavigator = operationNavigator;
    }

    public void run() {
        ioService.println("Калькулятор запущен. Команды: " + operationNavigator.availableKeys());
        ioService.println("Для выхода введите exit или 0");

        while (true) {
            ioService.print("Введите операцию: ");
            String command = ioService.readLine().trim();

            if ("exit".equalsIgnoreCase(command) || "0".equals(command)) {
                ioService.println("Выход из программы.");
                return;
            }

            Optional<Operation> operationOptional = operationNavigator.findByKey(command);
            if (operationOptional.isEmpty()) {
                ioService.println("Неизвестная команда: " + command);
                continue;
            }

            Operation operation = operationOptional.get();
            try {
                double result;
                if (operation.arity() == 1) {
                    double value = readNumber("Введите число: ");
                    result = operation.apply(value);
                } else {
                    double first = readNumber("Введите первое число: ");
                    double second = readNumber("Введите второе число: ");
                    result = operation.apply(first, second);
                }

                ioService.println("Результат: " + result);
            } catch (NumberFormatException ex) {
                ioService.println("Ошибка: нужно ввести корректное число.");
            } catch (IllegalArgumentException ex) {
                ioService.println("Ошибка: " + ex.getMessage());
            } catch (Exception ex) {
                ioService.println("Неожиданная ошибка: " + ex.getMessage());
            }
        }
    }

    private double readNumber(String prompt) {
        ioService.print(prompt);
        String input = ioService.readLine().trim();
        return Double.parseDouble(input);
    }
}
