package com.zupcash.service;

import com.zupcash.exception.SaldoNegativoException;
import com.zupcash.model.ContaCorrente;
import com.zupcash.model.Transacoes;
import com.zupcash.repository.ContaCorrenteRepository;
import com.zupcash.repository.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransacoesService {

    @Autowired
    TransacoesRepository transacoesRepository;

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    ContaCorrenteService contaCorrenteService;

    //Método que deposita dinheiro na conta de um cliente
    public Transacoes depositar(String contacorrente, BigDecimal valor) {
        Transacoes transacao = new Transacoes();

        transacao.setNumeroConta(contacorrente);
        transacao.setValor(valor);
        transacao.setServico("deposito");

        //ContaCorrente atualizaConta = contaCorrenteService.buscaId(id).orElse(null);
        ContaCorrente atualizaConta = contaCorrenteService.buscaContaCorrente(contacorrente).orElse(null);

        if(atualizaConta != null){
            BigDecimal valorDbAtual = atualizaConta.getValorAtual();
            BigDecimal valorDeposito = valor;

            BigDecimal somaDeposito = valorDbAtual.add(valorDeposito);

            atualizaConta.setValorAtual(somaDeposito);
            atualizaConta.setValorFinal(somaDeposito);

            contaCorrenteRepository.save(atualizaConta);

        }

        return transacoesRepository.save(transacao);
    }

    //Método que saca dinheiro da conta de um cliente
    public Transacoes sacar(String contacorrente, BigDecimal valor) {
        Transacoes transacao = new Transacoes();

        transacao.setNumeroConta(contacorrente);
        transacao.setValor(valor);
        transacao.setServico("saque");

        ContaCorrente atualizaConta = contaCorrenteService.buscaContaCorrente(contacorrente).orElse(null);

        if(atualizaConta != null){
            BigDecimal valorDbAtual = atualizaConta.getValorAtual();
            BigDecimal valorSaque = valor;

            BigDecimal subtracaoSaque = valorDbAtual.subtract(valorSaque);

            if(subtracaoSaque.compareTo(BigDecimal.ZERO) < 0){
                String mensagem = "Se você sacar R$" + valorSaque + " ficará com saldo negativo!";
               throw new SaldoNegativoException(mensagem);

            }

            atualizaConta.setValorAtual(subtracaoSaque);
            atualizaConta.setValorFinal(subtracaoSaque);

            contaCorrenteRepository.save(atualizaConta);

        }

        return transacoesRepository.save(transacao);
    }

}
