package com.khushi.productservice.testdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void whenAddTwoIntegersThenRightResultExpected() {
        // Arrange
        int a = 10;
        int b = 20;
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(a, b);

        // Assert
        Assertions.assertEquals(40, result);
//        if (result == 30) {
//            System.out.println("Success");
//        }
//        else {
//            throw new RuntimeException("Failure");
//        }
    }

    @Test
    void divide() {
        // Arrange
        int a = 10;
        int b = 0;
        Calculator calculator = new Calculator();

        Assertions.assertThrows(ArithmeticException.class,
                () -> calculator.divide(a,b));
    }
}