package xyz.rushd.service_layer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.rushd.service_layer.Calculator;
import xyz.rushd.service_layer.service.CalculatorService;


@RestController
@RequestMapping
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