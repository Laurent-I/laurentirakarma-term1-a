package rca.devops.exam.v1.controller;

// MathController.java
import org.springframework.web.bind.annotation.*;
import rca.devops.exam.v1.dto.DoMathRequest;
import rca.devops.exam.v1.dto.DoMathResponse;
import rca.devops.exam.v1.exception.InvalidOperationException;
import rca.devops.exam.v1.service.MathOperator;

@RestController
public class MathController {

    private final MathOperator mathOperator;

    public MathController(MathOperator mathOperator) {
        this.mathOperator = mathOperator;
    }

    @PostMapping("/doMath")
    public DoMathResponse doMath(@RequestBody DoMathRequest request) throws InvalidOperationException {
        double result = mathOperator.doMath(request.getOperand1(), request.getOperand2(), request.getOperation());
        return new DoMathResponse(result);
    }
}