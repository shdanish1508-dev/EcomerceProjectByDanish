package com.electronic.store.electronicstore.Validate;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

//@Target(
//        {ElementType.FIELD,ElementType.PARAMETER}
//)
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Constraint(validatedBy = ImageNameValidator.class)
//public @interface  ImageNameValid {
//    String message() default "Image Name is required";
//    class<?>[] groups() default{};
//    class<? extends Payload>[]payload() default {}
//}

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ImageNameValidator.class)
public @interface ImageNameValid {

    String message() default "Invalid Image Name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
