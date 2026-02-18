package xyz.rushd.service_layer.controller;

import org.springframework.http.ResponseEntity;
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

  // Redundant endpoints for testing

  @GetMapping("/add")
  public ResponseEntity<Integer> add(@RequestParam int firstNumber,
      @RequestParam int secondNumber) {
    int result = calculatorService.add(firstNumber, secondNumber);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/sub")
  public ResponseEntity<Integer> sub(@RequestParam int firstNumber,
      @RequestParam int secondNumber) {
    int result = calculatorService.sub(firstNumber, secondNumber);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/mul")
  public ResponseEntity<Integer> mul(@RequestParam int firstNumber,
      @RequestParam int secondNumber) {
    int result = calculatorService.mul(firstNumber, secondNumber);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/div")
  public ResponseEntity<Integer> div(@RequestParam int firstNumber,
      @RequestParam int secondNumber) {
    int result = calculatorService.div(firstNumber, secondNumber);
    return ResponseEntity.ok(result);
  }

}