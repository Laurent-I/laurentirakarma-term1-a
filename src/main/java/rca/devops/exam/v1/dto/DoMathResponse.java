package rca.devops.exam.v1.dto;

// DoMathResponse.java
public class DoMathResponse {
    private double calcResponse;

    public DoMathResponse(double calcResponse) {
        this.calcResponse = calcResponse;
    }

    public double getCalcResponse() {
        return calcResponse;
    }

    public void setCalcResponse(double calcResponse) {
        this.calcResponse = calcResponse;
    }

}
