package com.poo.aula_exceptions.exceptions;

public class OpcaoInvalidaException extends Exception implements MensagemError {
    public OpcaoInvalidaException(){
        super(OPCOES_INVALIDAS);
    }
}
