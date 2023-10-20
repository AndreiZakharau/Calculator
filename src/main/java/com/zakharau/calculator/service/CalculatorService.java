package com.zakharau.calculator.service;

import com.zakharau.calculator.model.ReadModel;
import com.zakharau.calculator.model.ViewModel;
import com.zakharau.calculator.util.ParserExample;
import java.util.Stack;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorService {

  private final ParserExample parser;
  private final MathOperations operations;

  public ViewModel calculation(ReadModel readModel) {

    String expression = readModel.getExample();
    ViewModel viewModel = new ViewModel();

    if (parser.isNotExample(expression)) {
      throw new RuntimeException(String.format("This example '%s' have invalid elements ", expression)); //TODO create exception
    } else {
      viewModel.setResult(getMathResult(expression));

    }
    return viewModel;
  }

  private double getMathResult(String example) {
    Stack<Double> numbers = new Stack<>();
    Stack<Character> operators = new Stack<>();
    for (int i = 0; i < example.length(); i++) {
      char c = example.charAt(i);

      if (Character.isDigit(c)) {
        StringBuilder sb = new StringBuilder();
        while (i < example.length() && (Character.isDigit(example.charAt(i)) || example.charAt(i) == '.')) {
          sb.append(example.charAt(i));
          i++;
        }
        i--;
        numbers.push(Double.parseDouble(sb.toString()));
      } else if (c == '+' || c == '-') {
        while (!operators.isEmpty() && (operators.peek() == '+' || operators.peek() == '-' || operators.peek() == '*' || operators.peek() == '/')) {
          numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }
        operators.push(c);
      } else if (c == '*' || c == '/') {
        while (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
          numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }
        operators.push(c);
      }
    }

    while (!operators.isEmpty()) {
      numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
    }

    return numbers.pop();
  }


  private double applyOperator(char operator, double b, double a) {
    switch (operator) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
      case ':':
        if (b == 0) {
          throw new ArithmeticException("Zero division is not allowed");
        }
        return a / b;
      default:
        return 0;
    }
  }
}





