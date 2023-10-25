package com.zakharau.calculator.controller;

import com.zakharau.calculator.model.ReadModel;
import com.zakharau.calculator.model.ViewModel;
import com.zakharau.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatorController implements CalculatorApi {

  private final CalculatorService service;

  @Override
  public ViewModel getResult(ReadModel readModel) {

    return service.calculation(readModel);
  }
}
