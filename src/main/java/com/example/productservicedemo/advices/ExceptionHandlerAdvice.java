package com.example.productservicedemo.advices;


import com.example.productservicedemo.dtos.ArithmeticExceptionDto;
import com.example.productservicedemo.dtos.ArrayIndexOutOfBoundExceptionDto;
import com.example.productservicedemo.dtos.ExceptionDto;
import com.example.productservicedemo.exceptions.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice  {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> hnadleArithmeticException(){
            ArithmeticExceptionDto dto = new ArithmeticExceptionDto();
            dto.setMessage("Something went wrong");
            return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ArrayIndexOutOfBoundExceptionDto> handleArrayIndexOutOfBoundException(){
        ArrayIndexOutOfBoundExceptionDto dto = new ArrayIndexOutOfBoundExceptionDto();
        dto.setMessage("Something went wrong in array");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ExceptionDto> handleInvalidProductByIdException(InvalidProductIdException exception){
        ExceptionDto dto = new ExceptionDto();
        dto.setProductId(exception.getProductId());
        dto.setMessage("Invalid product id passed, please retry with a valid productID");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
