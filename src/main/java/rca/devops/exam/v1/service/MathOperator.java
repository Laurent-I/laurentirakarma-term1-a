package rca.devops.exam.v1.service;

import rca.devops.exam.v1.exception.InvalidOperationException;

// MathOperator.java
public interface MathOperator {
    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}