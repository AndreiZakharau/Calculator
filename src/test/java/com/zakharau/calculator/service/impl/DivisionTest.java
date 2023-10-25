package com.zakharau.calculator.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionTest {

  private Division division;
  @BeforeEach
  void setUp() {
    division = new Division();
  }

  @Test
  void getResultDivisionIfNumberInteger() {

    double first = 11;
    double second = 10;
    double result = 1;

    double actualResult = division.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultDivisionIfNumberDouble() {

    double first = 5.5;
    double second = 1.1;
    double result = 4.4;

    double actualResult = division.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultDivisionIfFirstNumberIsNegative() {

    double first = -10;
    double second = 5;
    double result = -15;

    double actualResult = division.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultDivisionIfSecondNumberIsNegative() {

    double first = 10;
    double second = -5;
    double result = 15;

    double actualResult = division.getResult(first,  second);

    assertEquals(actualResult, result);
  }

  @Test
  void getResultDivisionIfAllNumbersIsNegative() {

    double first = -13.3;
    double second = -20.3;
    double result = 7;

    double actualResult = division.getResult(first,  second);

    assertEquals(actualResult, result);
  }
}