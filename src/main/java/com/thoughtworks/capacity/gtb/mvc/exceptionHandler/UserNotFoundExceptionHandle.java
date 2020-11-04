package com.thoughtworks.capacity.gtb.mvc.exceptionHandler;

import com.thoughtworks.capacity.gtb.mvc.domain.ResponseDTO;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserNotFoundExceptionHandle {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDTO> handler(UserNotFoundException e){
        String defaultMessage = e.getMsg();
        ResponseDTO responseDTO = new ResponseDTO(HttpStatus.NOT_FOUND.value(), defaultMessage);
        return ResponseEntity.badRequest().body(responseDTO);
    }
}
