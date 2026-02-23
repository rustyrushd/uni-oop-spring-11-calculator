package xyz.rushd.spring_calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.rushd.spring_calculator.model.Calculator;
import xyz.rushd.spring_calculator.service.OverflowThrowCalculatorService;

@RestController
@RequestMapping("/overflow-throw-calculator")
public class OverflowThrowCalculatorController {
  private final OverflowThrowCalculatorService overflowThrowCalculatorService;

  public OverflowThrowCalculatorController(
      OverflowThrowCalculatorService overflowThrowCalculatorService) {
    this.overflowThrowCalculatorService = overflowThrowCalculatorService;
  }

  @GetMapping("/calculate-exact")
  public ResponseEntity<Calculator> calculate(@RequestParam int firstNumber,
      @RequestParam String operation, @RequestParam int secondNumber) {
    Calculator calculator = new Calculator(firstNumber, operation, secondNumber);
    calculator.setResult(overflowThrowCalculatorService.operation(firstNumber, operation,
        secondNumber));
    return ResponseEntity.ok(calculator);
  }

  // Redundant endpoints for testing

  @GetMapping("/add-exact")
  public ResponseEntity<Integer> addExact(@RequestParam int firstNumber,
      @RequestParam int secondNumber) {
    int result = overflowThrowCalculatorService.addExact(firstNumber, secondNumber);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/sub-exact")
  public ResponseEntity<Integer> subExact(@RequestParam int firstNumber,
      @RequestParam int secondNumber) {
    int result = overflowThrowCalculatorService.subExact(firstNumber, secondNumber);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/mul-exact")
  public ResponseEntity<Integer> mulExact(@RequestParam int firstNumber,
      @RequestParam int secondNumber) {
    int result = overflowThrowCalculatorService.mulExact(firstNumber, secondNumber);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/div-exact")
  public ResponseEntity<?> divExact(@RequestParam int firstNumber,
      @RequestParam int secondNumber) {
    if  (secondNumber == 0) {
      return ResponseEntity.badRequest().body("Div (exact) by zero, validation in controller :0!");
    }
    int result = overflowThrowCalculatorService.divExact(firstNumber, secondNumber);
    return ResponseEntity.ok(result);
  }

}
