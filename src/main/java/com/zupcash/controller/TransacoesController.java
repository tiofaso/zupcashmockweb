package com.zupcash.controller;

import com.zupcash.dto.TransacoesDTO;
import com.zupcash.mapper.TransacoesMapper;
import com.zupcash.model.Transacoes;
import com.zupcash.service.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class TransacoesController {

    @Autowired
    TransacoesService transacoesService;

    @Autowired
    TransacoesMapper transacoesMapper;

    //Endpoint de insercao e de alteração
    //Post - insere valores na conta do cliente
    @PostMapping(path = "/zupcash/deposito/{contacorrente}/{valor}" )
    @ResponseStatus(HttpStatus.CREATED)
    public TransacoesDTO depositarDinheiro(@PathVariable String contacorrente, @PathVariable BigDecimal valor) {
        Transacoes deposito = transacoesService.depositar(contacorrente,valor);

        deposito.setNumeroConta(contacorrente);
        deposito.setValor(valor);

        return transacoesMapper.toDto(deposito);
    }

    //Endpoint de insercao e alteração
    //Post - remove valores na conta do cliente
    @PostMapping(path = "/zupcash/saque/{contacorrente}/{valor}" )
    @ResponseStatus(HttpStatus.CREATED)
    public TransacoesDTO sacarDinheiro(@PathVariable String contacorrente, @PathVariable BigDecimal valor) {
        Transacoes saque = transacoesService.sacar(contacorrente,valor);

        saque.setNumeroConta(contacorrente);
        saque.setValor(valor);

        return transacoesMapper.toDto(saque);
    }

}
