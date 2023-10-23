package com.zakharau.calculator.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.zakharau.calculator.model.ReadModel;
import com.zakharau.calculator.model.ViewModel;
import com.zakharau.calculator.util.ParserExample;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

  @InjectMocks
  CalculatorService calculatorService;
  @Mock
  private ParserExample parserExample;

  @Test
  void calculation() {

    String expression = "5 + 5 * 5 - 10 - 5 * 2 : 2.5";
    ReadModel readModel= ReadModel.builder()
        .example(expression).build();
    ViewModel viewModel = ViewModel.builder().result(16).build();

    when(parserExample.isNotExample(expression)).thenReturn(true);
//    when();

    ViewModel actual = calculatorService.calculation(readModel);

    assertEquals(actual.getResult(), 16);
  }
}