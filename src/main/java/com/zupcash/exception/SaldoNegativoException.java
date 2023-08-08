package com.zupcash.exception;

public class SaldoNegativoException extends RuntimeException {
    public SaldoNegativoException(String message) {
        super(message);
    }
}

