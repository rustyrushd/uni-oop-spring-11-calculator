package xyz.rushd.spring_calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CalculatorController {

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
