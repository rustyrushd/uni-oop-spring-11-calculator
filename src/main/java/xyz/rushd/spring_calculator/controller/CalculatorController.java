package xyz.rushd.spring_calculator.controller;

import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Calculator> calculate(@RequestParam int firstNumber,
      @RequestParam String operation, @RequestParam int secondNumber) {
    Calculator calculator = new Calculator(firstNumber, operation, secondNumber);
    calculator.setResult(calculatorService.operation(firstNumber, operation, secondNumber));
    return ResponseEntity.ok(calculator);
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
  public ResponseEntity<?> div(@RequestParam int firstNumber,
      @RequestParam int secondNumber) {
    if  (secondNumber == 0) {
      return ResponseEntity.badRequest().body("Division by zero buddy :/");
    }
    int result = calculatorService.div(firstNumber, secondNumber);
    return ResponseEntity.ok(result);
  }

}