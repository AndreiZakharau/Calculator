package com.zakharau.calculator.service;

import com.zakharau.calculator.exception.InvalidDataException;
import com.zakharau.calculator.model.ReadModel;
import com.zakharau.calculator.model.ViewModel;
import com.zakharau.calculator.service.impl.Addition;
import com.zakharau.calculator.service.impl.Division;
import com.zakharau.calculator.service.impl.Multiplication;
import com.zakharau.calculator.service.impl.Subtraction;
import com.zakharau.calculator.util.ParserExample;
import java.util.Stack;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorService {

  private final ParserExample parser;
  private final Addition addition;
  private final Division division;
  private final Multiplication multiplication;
  private final Subtraction subtraction;

  public ViewModel calculation(ReadModel readModel) {

    String expression = readModel.getExample();
    ViewModel viewModel = new ViewModel();

    if (!parser.isNotExample(expression)) {
      throw new InvalidDataException(String.format("This example '%s' have invalid elements ", expression));
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
        while (!operators.isEmpty() && (operators.peek() == '+' || operators.peek() == '-' || operators.peek() == '*' || operators.peek() == ':')) {
          numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }
        operators.push(c);
      } else if (c == '*' || c == ':') {
        while (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == ':')) {
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


  private double applyOperator(char operator,  double second, double first) {

    switch (operator) {
      case '+':
        return addition.getResult(first, second);
      case '-':
        return division.getResult(first, second);
      case '*':
        return multiplication.getResult(first, second);
      case ':':
        if (first == 0) {
          throw new ArithmeticException("Zero division is not allowed");
        }

        return subtraction.getResult(first, second);
      default:

        return 0;
    }
  }
}





