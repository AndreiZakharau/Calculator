package com.zakharau.calculator.controller;

import com.zakharau.calculator.model.ReadModel;
import com.zakharau.calculator.model.ViewModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/calculator")
public interface CalculatorApi {

  @GetMapping
  ViewModel getResult(@RequestBody ReadModel readModel);

}
