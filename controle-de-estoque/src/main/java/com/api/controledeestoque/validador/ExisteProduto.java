package com.api.controledeestoque.validador;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExisteProdutoValidator.class)

public @interface ExisteProduto {
    String message() default "Não existe registro de produto com este identificador";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
