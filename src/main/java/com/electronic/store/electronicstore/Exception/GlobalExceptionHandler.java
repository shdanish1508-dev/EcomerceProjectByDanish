package com.electronic.store.electronicstore.Exception;


import com.electronic.store.electronicstore.Dtos.ApiResponsemessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GlobalExceptionHandler {

    // handler  resource not found exception


    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(ResourceNotfoundException.class)
    public ResponseEntity<ApiResponsemessage>resourceNotFoundExceptionHandler(ResourceNotfoundException ex)
    {

      logger.info("Exception handler invoked !!");
       ApiResponsemessage responsemessage = ApiResponsemessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();

       return new ResponseEntity<>(responsemessage,HttpStatus.NOT_FOUND);

    }


    public ResponseEntity<Map<String,Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {


          List<ObjectError>allError= ex.getBindingResult().getAllErrors();

          Map<String, Object> response= new HashMap<>();
          allError.stream().forEach(e->{
            String message=  ObjectError.getDefaultMessage();
            String field=  ((FieldError)ObjectError).getField();
              response.put(field, message);
          });

          return  new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(BadApiRequest.class)
    public  ResponseEntity<ApiResponsemessage>HandleBadApiRequest(BadApiRequest ex)
    {
        logger.info("Bad Api Request!!");
        ApiResponsemessage  response= ApiResponsemessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(false  ).build();

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
