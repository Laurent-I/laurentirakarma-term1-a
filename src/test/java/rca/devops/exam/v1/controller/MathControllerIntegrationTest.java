package rca.devops.exam.v1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import rca.devops.exam.v1.exception.InvalidOperationException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDoMathEndpointAddition() throws Exception {
        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":5, \"operand2\":3, \"operation\":\"+\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDoMathEndpointSubtraction() throws Exception {
        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":5, \"operand2\":3, \"operation\":\"-\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDoMathEndpointMultiplication() throws Exception {
        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":5, \"operand2\":3, \"operation\":\"*\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDoMathEndpointDivision() throws Exception {
        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":6, \"operand2\":3, \"operation\":\"/\"}"))
                .andExpect(status().isOk());
    }


    @Test
    public void testDoMathEndpointDivisionByZero() throws Exception {
        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":5, \"operand2\":0, \"operation\":\"/\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidOperationException));
    }

    @Test
    public void testDoMathEndpointUnknownOperation() throws Exception {
        mockMvc.perform(post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operand1\":5, \"operand2\":3, \"operation\":\"^\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof RuntimeException));
    }
}