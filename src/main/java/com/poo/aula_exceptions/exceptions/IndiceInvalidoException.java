package com.poo.aula_exceptions.exceptions;

public class IndiceInvalidoException extends Exception implements MensagemError {
    public IndiceInvalidoException(){
        super(INDICE_INVALIDO);
    }
}
