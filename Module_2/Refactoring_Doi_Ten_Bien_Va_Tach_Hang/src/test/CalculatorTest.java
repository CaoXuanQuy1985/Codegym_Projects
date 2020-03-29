package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char WRONGOPERATOR = '=';

    @Test
    @DisplayName("Testing addition")
    void testCalculateAdd() {
        int firstOperand = 1;
        int secondOperand = 1;
        int expected = 2;

        int result = Calculator.calculate(firstOperand, secondOperand, ADDITION);
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing subtraction")
    void testCalculateSub() {
        int firstOperand = 2;
        int secondOperand = 1;
        int expected = 1;

        int result = Calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing multiplication")
    void testCalculateMul() {
        int firstOperand = 2;
        int secondOperand = 2;
        int expected = 4;

        int result = Calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division")
    void testCalculateDiv() {
        int firstOperand = 6;
        int secondOperand = 3;
        int expected = 2;

        int result = Calculator.calculate(firstOperand, secondOperand, DIVISION);
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division by zero")
    void testCalculateDivByZero() {
        int firstOperand = 2;
        int secondOperand = 0;

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculate(firstOperand, secondOperand, DIVISION);});
    }

    @Test
    @DisplayName("Testing wrong operator")
    void testCalculateWrongOperator() {
        int firstOperand = 2;
        int secondOperand = 0;

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculate(firstOperand, secondOperand, WRONGOPERATOR);});
    }

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        test.testCalculateAdd();
        test.testCalculateDiv();
        test.testCalculateMul();
        test.testCalculateSub();
        test.testCalculateDivByZero();
        test.testCalculateWrongOperator();
    }
}