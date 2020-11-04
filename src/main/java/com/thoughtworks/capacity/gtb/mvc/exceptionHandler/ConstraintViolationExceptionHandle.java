package com.thoughtworks.capacity.gtb.mvc.exceptionHandler;

import com.thoughtworks.capacity.gtb.mvc.domain.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ConstraintViolationExceptionHandle {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseDTO> handler(ConstraintViolationException e){
        String defaultMessage = e.getMessage();
        ResponseDTO responseDTO = new ResponseDTO(HttpStatus.BAD_REQUEST.value(), defaultMessage);
        return ResponseEntity.badRequest().body(responseDTO);
    }
}
