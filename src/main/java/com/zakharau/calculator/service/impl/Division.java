package com.zakharau.calculator.service.impl;

import com.zakharau.calculator.service.MathOperations;
import org.springframework.stereotype.Service;

@Service
public class Division implements MathOperations {

  @Override
  public double getResult(double first, double second) {

    return  first - second;
  }
}