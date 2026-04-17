package ec.edu.epn.calculator;

import junit.framework.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testSum(){
        Calculator calculator = new Calculator();
        int result = calculator.sum(2, 2);
        if(result != 4){
            Assert.fail();
        }
    }
}