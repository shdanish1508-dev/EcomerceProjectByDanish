package com.electronic.store.electronicstore.Validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ImageNameValidator implements ConstraintValidator<ImageNameValid,String>
{


    @Override
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public boolean isValid(String Value, ConstraintValidatorContext context) {
        ,private Logger logger = LoggerFactory.getLogger(ImageNameValidator.class);

        logger.info("Message from IsValid: {}", Value);


      if(Value.isBlank())
      {
          return false;
      }
      else {
          return true;
      }


       return false;
    }
}
