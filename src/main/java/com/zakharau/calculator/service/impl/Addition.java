package com.zakharau.calculator.service.impl;

import com.zakharau.calculator.service.MathOperations;

public class Addition implements MathOperations {

  @Override
  public double getResult(double first, double second) {

    return first + second;
  }
}
