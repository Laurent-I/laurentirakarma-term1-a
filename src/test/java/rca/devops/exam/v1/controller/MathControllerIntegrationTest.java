package rca.devops.exam.v1.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rca.devops.exam.v1.exception.InvalidOperationException;
import rca.devops.exam.v1.service.MathOperator;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class MathControllerIntegrationTest {

    @Mock
    private MathOperator mathOperator;

    @InjectMocks
    private MathController mathController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
    }

    @Test
    public void testDoMathEndpointAddition() throws Exception {
        when(mathOperator.doMath(5, 3, "+")).thenReturn(8.0);

        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":5, \"operand2\":3, \"operation\":\"+\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDoMathEndpointSubtraction() throws Exception {
        when(mathOperator.doMath(5, 3, "-")).thenReturn(2.0);

        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":5, \"operand2\":3, \"operation\":\"-\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDoMathEndpointMultiplication() throws Exception {
        when(mathOperator.doMath(5, 3, "*")).thenReturn(15.0);

        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":5, \"operand2\":3, \"operation\":\"*\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDoMathEndpointDivision() throws Exception {
        when(mathOperator.doMath(6, 3, "/")).thenReturn(2.0);

        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":6, \"operand2\":3, \"operation\":\"/\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDoMathEndpointDivisionByZero() throws Exception {
        when(mathOperator.doMath(5, 0, "/")).thenThrow(new InvalidOperationException("Cannot divide by 0"));

        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":5, \"operand2\":0, \"operation\":\"/\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidOperationException));
    }

    @Test
    public void testDoMathEndpointUnknownOperation() throws Exception {
        when(mathOperator.doMath(5, 3, "^")).thenThrow(new RuntimeException("Unknown operation"));

        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":5, \"operand2\":3, \"operation\":\"^\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof RuntimeException));
    }

    @Test
    public void testDoMathEndpointAdditionWithNegativeNumbers() throws Exception {
        when(mathOperator.doMath(-5, -3, "+")).thenReturn(-8.0);

        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":-5, \"operand2\":-3, \"operation\":\"+\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDoMathEndpointSubtractionWithNegativeNumbers() throws Exception {
        when(mathOperator.doMath(-5, -3, "-")).thenReturn(-2.0);

        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":-5, \"operand2\":-3, \"operation\":\"-\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDoMathEndpointMultiplicationWithNegativeNumbers() throws Exception {
        when(mathOperator.doMath(-5, -3, "*")).thenReturn(15.0);

        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":-5, \"operand2\":-3, \"operation\":\"*\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDoMathEndpointDivisionWithNegativeNumbers() throws Exception {
        when(mathOperator.doMath(-6, -3, "/")).thenReturn(2.0);

        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":-6, \"operand2\":-3, \"operation\":\"/\"}"))
                .andExpect(status().isOk());
    }
}