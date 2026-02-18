package xyz.rushd.service_layer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

  public Calculator() {
    this.firstNumber = 0 ;
    this.operation = "";
    this.secondNumber = 0;
  }
}
