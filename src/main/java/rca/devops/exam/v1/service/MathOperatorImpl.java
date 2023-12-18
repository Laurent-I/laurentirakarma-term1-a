package rca.devops.exam.v1.service;

import org.springframework.stereotype.Service;
import rca.devops.exam.v1.exception.InvalidOperationException;

// MathOperatorImpl.java
@Service
public class MathOperatorImpl implements MathOperator {
    @Override
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException {
        if ("/".equals(operation) && operand2 == 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }
        return switch (operation) {
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            default -> throw new RuntimeException("Unknown operation");
        };
    }
}
