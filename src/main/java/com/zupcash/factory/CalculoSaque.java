package com.zupcash.factory;

import java.math.BigDecimal;

public class CalculoSaque implements CalculoConta {
    @Override
    public BigDecimal calcular(BigDecimal valorAtual, BigDecimal valorFornecido) {
        BigDecimal resultado = valorAtual.subtract(valorFornecido);
        return resultado;
    }
}
