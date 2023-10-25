package com.zakharau.calculator.controller.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.zakharau.calculator.exception.ExceptionInformation;
import com.zakharau.calculator.exception.InvalidDataException;
import jakarta.servlet.ServletException;
import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@RestControllerAdvice
public class CommonExceptionHandler {

  @ExceptionHandler(ServletException.class)
  @ResponseStatus(INTERNAL_SERVER_ERROR)
  public ExceptionInformation handleServletException(ServletException exception) {
    return new ExceptionInformation(
        INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR.value(), "Houston, we have a problem");
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(INTERNAL_SERVER_ERROR)
  public ExceptionInformation handleGeneralException(Exception exception) {
    return new ExceptionInformation(
        INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR.value(), exception.getMessage());
  }

  @ExceptionHandler(InvalidDataException.class)
  @ResponseStatus(BAD_REQUEST)
  public ExceptionInformation handleGeneralException(InvalidDataException exception) {
    return new ExceptionInformation(
        BAD_REQUEST, BAD_REQUEST.value(), exception.getMessage());
  }

  @ExceptionHandler(BadRequest.class)
  @ResponseStatus(BAD_REQUEST)
  public ExceptionInformation handleBadRequestException(BadRequest exception) {
    return new ExceptionInformation(BAD_REQUEST, BAD_REQUEST.value(), exception.getMessage());
  }

  @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
  @ResponseStatus(BAD_REQUEST)
  public ExceptionInformation handleMethodArgumentNotValidException(BindException exception) {
    var message =
        exception.getBindingResult().getAllErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.joining(", "));
    return new ExceptionInformation(BAD_REQUEST, BAD_REQUEST.value(), message);
  }

}
