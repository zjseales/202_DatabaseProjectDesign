/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import myClasses.Calculator;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** CalculatorTest.java
 *  INFO202 Lab02
 *
 *  Automated test for the Calculator class.
 *@author Zac Seales - 6687905
 */
public class CalculatorTest {
    
    private Calculator calc;

    @BeforeEach
    public void setUp() {
        calc = new Calculator();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAdd() {
        //calls the add method of the Calculator class.
        Integer result = calc.add(3,4);
        
        //tests that the add method returns the correct result.
        assertThat(result, is(7));
        
        //additional tests (more comprehensive proof 
        // that the method works correctly).
        assertThat(calc.add(1,2), is(3));
        assertThat(calc.add(5,-4), is(1));
        assertThat(calc.add(-5,4), is(-1));
        assertThat(calc.add(4,-8), is(-4));
        assertThat(calc.add(-1,-5), is(-6));
    }

    @Test
    public void testMultiply() {
        //tests to ensure multiply method works correctly.
        assertThat(calc.multiply(3,4), is(12));
        assertThat(calc.multiply(1,2), is(2));
        assertThat(calc.multiply(5,-4), is(-20));
        assertThat(calc.multiply(-5,4), is(-20));
        assertThat(calc.multiply(4,-8), is(-32));
        assertThat(calc.multiply(-1,-5), is(5));
    }
    
}
