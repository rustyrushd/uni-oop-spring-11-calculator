package xyz.rushd.spring_calculator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class CalculatorController {

  @GetMapping("/calculate")
  public Calculator calculate(@RequestParam int firstNumber, @RequestParam String operation,
                              @RequestParam int secondNumber) {
    Calculator calculator = new Calculator(firstNumber, operation, secondNumber);
    int result = switch (operation) {
      case "+" -> add(firstNumber, secondNumber);
      case "-" -> sub(firstNumber, secondNumber);
      case "*" -> mul(firstNumber, secondNumber);
      case "/" -> {
        if (secondNumber == 0) {
          throw new IllegalArgumentException("Division by zero: To infinity and beyond, "
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
    calculator.setResult(result);
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

  // Translate Java IllegalArgumentException into HTTP responses
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  public String handleBadRequest(IllegalArgumentException ex) {
    return ex.getMessage();
  }
}