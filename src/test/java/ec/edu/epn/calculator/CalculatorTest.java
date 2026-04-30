package ec.edu.epn.calculator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import junit.framework.Assert;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    public void setUp() {
        // Arrange
        calculator = new Calculator();
    }

    @DisplayName("Prueba unitaria que realiza la verificacion del metodo ")
    @Test
    public void testSum() {
        //arrange + Act
        int resultado = calculator.sum(2, 2);
        // assert
        assertEquals(4, resultado);
    }

    @Test
    public void testSum2(){
//        //Arrange + Act
//        int result = calculator.sum(4, 6);
//        //Assert
//        assertEquals(10, result);
        assertAll("Suma valores en varios casos",
                () -> {
                    int resultado = calculator.sum(2, 2);
                    assertEquals(4, resultado);
                },
                () -> assertEquals(0, calculator.sum(-1, 1))
        );

    }

    @ParameterizedTest
    @CsvSource({
            "2, 1, 3",
            "0, 5, 5",
            "-1, 2, 1"

    })
    public void testSumMultipleData(int a, int b, int expected){
        //Arrange + Act
        int result = calculator.sum(a, b);
        //Assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10, 100, -1})
    public void testSumWithFixedValues(int value){
        //Arrange + Act
        int result = calculator.sum(value, 0);
        //Assert
        assertTrue(result == value);
    }

    @Test
    public void testMinus(){
        //arrange + Act
        int resultado = calculator.minus(2, 1);
        // assert
        assertEquals(1, resultado);
    }

    @Test
    public void testDivideSuccess(){
        //arrange + Act
        int resultado = calculator.divide(8, 2);
        // Assert
        assertEquals(4, resultado);
    }

    @Test
    public void testMultiply(){
        // arrange + Act
        int resultado = calculator.multiply(4, 4);
        // assert
        assertEquals(16, resultado);
    }

    @Test
    public void testDivideFail(){
        // arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });
    }
}

