package xyz.rushd.spring_calculator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CalculatorExceptionHandler {

  // Translate Java IllegalArgumentException into HTTP 400 response
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  public String handleIllegalArgumentException(IllegalArgumentException ex) {
    return ex.getMessage();
  }

  // Translate Java ArithmeticException into HTTP 400 response
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ArithmeticException.class)
  public String handleArithmeticException(ArithmeticException ex) {
    return ex.getMessage();
  }

}
