package com.zakharau.calculator.controller;

import com.zakharau.calculator.model.ReadModel;
import com.zakharau.calculator.model.ViewModel;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/calculator")
@Validated
public interface CalculatorApi {

  @GetMapping
  ViewModel getResult(@Valid @RequestBody ReadModel readModel);

}
