package com.easybytes.easyschool.annotation;

import com.easybytes.easyschool.validations.FieldsValueMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsValueMatch {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Fields value do not match";


    // ****** This below code lines is required to compare two annotations ******
    String field();

    String fieldMatch();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        FieldsValueMatch[] value();
    }

    // ****** This above code is responsible to accept the two fields information ******
}
