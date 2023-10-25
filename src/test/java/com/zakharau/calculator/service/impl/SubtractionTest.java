package com.zakharau.calculator.service.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubtractionTest {

  private  Subtraction subtraction;

  @BeforeEach
  void setUp() {
    subtraction = new Subtraction();
  }

  @Test
  void getResultSubtraction() {

    double first = 26.5;
    double second = 10;
    double  result = 2.65;

    double actualResult = subtraction.getResult(first, second);

    assertEquals(actualResult, result);
   }

  @Test
  void getResultSubtractionIfNumberInteger() {

    double first = 81;
    double second = 9;
    double  result = 9;

    double actualResult = subtraction.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultSubtractionIfNumberDouble() {

    double first = 26.25;
    double second = 2.5;
    double  result = 10.5;

    double actualResult = subtraction.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultSubtractionIfFirstNumberIsNegative() {

    double first = -35;
    double second = 3.5;
    double result = -10;

    double actualResult = subtraction.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultSubtractionIfSecondNumberIsNegative() {

    double first = 35;
    double second = -3.5;
    double result = -10;

    double actualResult = subtraction.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultSubtractionIfFirstAndSecondIsNegative() {

    double first = -35;
    double second = -3.5;
    double result = 10;

    double actualResult = subtraction.getResult(first,  second);

    assertEquals(actualResult, result);
  }
}