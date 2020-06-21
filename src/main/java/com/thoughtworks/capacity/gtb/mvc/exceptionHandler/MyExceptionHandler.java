package com.thoughtworks.capacity.gtb.mvc.exceptionHandler;

import com.thoughtworks.capacity.gtb.mvc.exception.MismatchException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<ErrorResult> handleUserExistException(UserExistException ex){
        ErrorResult errorResult= new ErrorResult(HttpStatus.BAD_REQUEST,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        FieldError error = ex.getBindingResult().getFieldError();
        String errorMessage = error!=null? error.getDefaultMessage():"Something went wrong";
        ErrorResult errorResult =new ErrorResult(HttpStatus.BAD_REQUEST,errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }


    @ExceptionHandler(MismatchException.class)
    public ResponseEntity<ErrorResult> handleUserExistException(MismatchException ex){
        ErrorResult errorResult= new ErrorResult(HttpStatus.BAD_REQUEST,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResult> handleConstraintViolationException(ConstraintViolationException ex){
        ErrorResult errorResult= new ErrorResult(HttpStatus.BAD_REQUEST,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

}
