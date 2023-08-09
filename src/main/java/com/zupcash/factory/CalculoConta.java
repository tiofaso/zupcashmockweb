package com.zupcash.factory;

import java.math.BigDecimal;

public interface CalculoConta {
    public BigDecimal calcular(BigDecimal valorAtual, BigDecimal valorFornecido);
}
