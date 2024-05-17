package com.teste.santander.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors extends StandardError {
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationErrors() {
        super();
    }

    public ValidationErrors(Long timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String campoNome, String mensagem) {
        this.errors.add(new FieldMessage(campoNome, mensagem));
    }

    
    
    
}
