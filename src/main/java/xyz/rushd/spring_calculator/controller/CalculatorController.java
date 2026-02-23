package xyz.rushd.spring_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.rushd.spring_calculator.model.Calculator;
import xyz.rushd.spring_calculator.service.CalculatorService;


@RestController
@RequestMapping("/calculator")
public class CalculatorController {
  private final CalculatorService calculatorService;

  public CalculatorController(CalculatorService calculatorService) {
    this.calculatorService = calculatorService;
  }

  @GetMapping("/calculate")
  public Calculator calculate(@RequestParam int firstNumber, @RequestParam String operation,
      @RequestParam int secondNumber) {
    Calculator calculator = new Calculator(firstNumber, operation, secondNumber);
    calculator.setResult(calculatorService.operation(firstNumber, operation, secondNumber));
    return calculator;
  }

  // Redundant endpoints for testing

  @GetMapping("/add")
  public int add(@RequestParam int firstNumber, @RequestParam int secondNumber) {
    return firstNumber + secondNumber;
  }

  @GetMapping("/sub")
  public int sub(@RequestParam int firstNumber, @RequestParam int secondNumber) {
    return firstNumber - secondNumber;
  }

  @GetMapping("/mul")
  public int mul(@RequestParam int firstNumber, @RequestParam int secondNumber) {
    return firstNumber * secondNumber;
  }

  @GetMapping("/div")
  public int div(@RequestParam int firstNumber, @RequestParam int secondNumber) {
    return firstNumber / secondNumber;
  }

}