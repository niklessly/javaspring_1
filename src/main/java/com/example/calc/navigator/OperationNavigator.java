package com.example.calc.navigator;

import com.example.calc.operation.Operation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class OperationNavigator {
    private final Map<String, Operation> operationMap = new LinkedHashMap<>();

    public OperationNavigator(List<Operation> operations) {
        for (Operation operation : operations) {
            operationMap.put(operation.key(), operation);
        }
    }

    public Optional<Operation> findByKey(String key) {
        return Optional.ofNullable(operationMap.get(key));
    }

    public Set<String> availableKeys() {
        return operationMap.keySet();
    }
}
