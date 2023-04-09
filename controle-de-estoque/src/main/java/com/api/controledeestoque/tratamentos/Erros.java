package com.api.controledeestoque.tratamentos;

import org.springframework.validation.FieldError;

public class Erros {
    private String campo;
    private String erro;

    public Erros(FieldError fieldError) {
        this.campo = fieldError.getField();
        this.erro = fieldError.getField();
    }

    public Erros(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
