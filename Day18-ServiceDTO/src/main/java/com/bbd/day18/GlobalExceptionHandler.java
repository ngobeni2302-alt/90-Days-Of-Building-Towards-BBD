package com.bbd.day18;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String,String>> handle404(EmployeeNotFoundException ex){
        return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handle400(MethodArgumentNotValidException ex){
        Map<String,String> err=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e->err.put(e.getField(), e.getDefaultMessage()));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
