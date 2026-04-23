package ec.edu.epn.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        int resultado = calculator.sum(2, 2);
        assertEquals(4, resultado);
    }

    @Test
    public void testMinus(){
        int resultado = calculator.minus(2, 1);
        assertEquals(1, resultado);
    }

    @Test
    public void testDivideSuccess(){
        int resultado = calculator.divide(8, 2);
        assertEquals(4, resultado);
    }

    @Test
    public void testMultiply(){
        int resultado = calculator.multiply(4, 4);
        assertEquals(16, resultado);
    }

    @Test
    public void testDivideFail(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });
    }
}

