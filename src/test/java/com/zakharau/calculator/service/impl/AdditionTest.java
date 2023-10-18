package com.zakharau.calculator.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdditionTest {

  private Addition addition;

  @BeforeEach
  void setUp() {
    addition = new Addition();
  }

  @Test
  void getResultAddition() {

    double first = 10;
    double second = 1.5;
    double result = 11.5;

    double actualResult = addition.getResult( first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultAdditionIfNumberInteger() {

    double first = 10;
    double second = 10;
    double result = 20;

    double actualResult = addition.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultAdditionIfNumberDouble() {

    double first = 5.5;
    double second = 6.6;
    double result = 12.1;

    double actualResult = addition.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultAdditionIfFirstNumberIsNegative() {

    double first = -10;
    double second = 15;
    double result = 5;

    double actualResult = addition.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultAdditionIfSecondNumberIsNegative() {

    double first = 10;
    double second = -5;
    double result = 5;

    double actualResult = addition.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultAdditionIfResultIsNegative() {

    double first = -13.3;
    double second = 10;
    double result = 3.3;

    double actualResult = addition.getResult(first,  second);

    assertEquals(actualResult, result);
  }
}