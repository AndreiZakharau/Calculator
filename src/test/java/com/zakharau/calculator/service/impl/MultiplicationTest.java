package com.zakharau.calculator.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiplicationTest {

  private Multiplication multiplication;

  @BeforeEach
  void setUp() {
    multiplication = new Multiplication();
  }

  @Test
  void getResultMultiplicationIfNumberInteger() {

    double first = 10;
    double second = 10;
    double result = 100;

    double actualResult = multiplication.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultMultiplicationIfNumberDouble() {

    double first = 5.5;
    double second = 5.5;
    double result = 30.25;

    double actualResult = multiplication.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultMultiplicationIfFirstNumberIsNegative() {

    double first = -10;
    double second = 5;
    double result = -50;

    double actualResult = multiplication.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultMultiplicationIfSecondNumberIsNegative() {

    double first = 10;
    double second = -5;
    double result = 50;

    double actualResult = multiplication.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultMultiplicationIfAllNumberIsNegative() {

    double first = -13.3;
    double second = -10;
    double result = 133;

    double actualResult = multiplication.getResult(first,  second);

    assertEquals(actualResult, result);
  }
}