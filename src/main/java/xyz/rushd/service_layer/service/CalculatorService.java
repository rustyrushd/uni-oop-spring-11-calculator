package xyz.rushd.service_layer.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

  public int operation(int firstNumber, String operation, int secondNumber) {
    return switch (operation) {
      case "+" -> add(firstNumber, secondNumber);
      case "-" -> sub(firstNumber, secondNumber);
      case "*" -> mul(firstNumber, secondNumber);
      case "/" -> {
        if (secondNumber == 0) {
          throw new ArithmeticException("Division by zero: To infinity and beyond, "
              + "as the second number = 0! " + "🚀");
        } else {
          yield div(firstNumber, secondNumber);
        }
      }
      default -> {
        throw new IllegalArgumentException("Invalid operation selected, please type \"+\" to add, "
            + "\"-\" to subtract, \"*\" to multiply or \"/\" to divide next time.");
      }
    };
  }


  public int add(int firstNumber, int secondNumber) {
    return firstNumber + secondNumber;
  }

  public int sub(int firstNumber, int secondNumber) {
    return firstNumber - secondNumber;
  }

  public int mul(int firstNumber, int secondNumber) {
    return firstNumber * secondNumber;
  }

  public int div(int firstNumber, int secondNumber) {
    return firstNumber / secondNumber;
  }
}
