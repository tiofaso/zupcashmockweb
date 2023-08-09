package com.zupcash.factory;

import java.math.BigDecimal;

public class CalculoDeposito implements CalculoConta {
    @Override
    public BigDecimal calcular(BigDecimal valorAtual, BigDecimal valorFornecido) {
        BigDecimal resultado = valorAtual.add(valorFornecido);
        return resultado;
    }
}
