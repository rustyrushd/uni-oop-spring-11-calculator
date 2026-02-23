package xyz.rushd.spring_calculator.service;

import org.springframework.stereotype.Service;

@Service
public class OverflowThrowCalculatorService {

  public int operation(int firstNumber, String operation, int secondNumber) {
    return switch (operation) {
      case "+" -> addExact(firstNumber, secondNumber);
      case "-" -> subExact(firstNumber, secondNumber);
      case "*" -> mulExact(firstNumber, secondNumber);
      case "/" -> {
        if (secondNumber == 0) {
          throw new ArithmeticException("Division by zero: To infinity and beyond, "
              + "as the second number = 0! " + "🚀");
        } else {
          yield divExact(firstNumber, secondNumber);
        }
      }
      default -> {
        throw new IllegalArgumentException("Invalid operation selected, please type \"+\" to add, "
            + "\"-\" to subtract, \"*\" to multiply or \"/\" to divide next time.");
      }
    };
  }

  public int addExact(int firstNumber, int secondNumber) {
    return Math.addExact(firstNumber, secondNumber);
  }

  public int subExact(int firstNumber, int secondNumber) {
    return Math.subtractExact(firstNumber, secondNumber);
  }

  public int mulExact(int firstNumber, int secondNumber) {
    return Math.multiplyExact(firstNumber, secondNumber);
  }

  public int divExact(int firstNumber, int secondNumber) {
    return Math.divideExact(firstNumber, secondNumber);
  }
}
