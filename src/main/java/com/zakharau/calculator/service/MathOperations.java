package com.zakharau.calculator.service;

import org.springframework.stereotype.Service;

@Service
public interface MathOperations {

  double getResult(double first, double second);
}
