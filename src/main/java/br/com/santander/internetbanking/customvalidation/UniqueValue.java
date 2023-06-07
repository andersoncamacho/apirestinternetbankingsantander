package br.com.santander.internetbanking.customvalidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueValueValidation.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

    String message() default "Atributo já esta cadastrado";

    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

    Class<?> domainClass();

    String fieldName();
}
