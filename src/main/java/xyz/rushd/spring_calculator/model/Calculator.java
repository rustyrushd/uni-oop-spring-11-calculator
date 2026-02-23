package xyz.rushd.spring_calculator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Calculator {
  private int firstNumber;
  private String operation;
  private int secondNumber;
  private int result;

  public Calculator(int firstNumber, String operation, int secondNumber) {
    this.firstNumber = firstNumber;
    this.operation = operation;
    this.secondNumber = secondNumber;
  }

}
