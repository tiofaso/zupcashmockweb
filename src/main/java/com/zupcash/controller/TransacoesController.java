package com.zupcash.controller;

import com.zupcash.model.ContaCorrente;
import com.zupcash.model.Transacoes;
import com.zupcash.repository.ContaCorrenteRepository;
import com.zupcash.service.ContaCorrenteService;
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

    //Endpoint de insercao e de alteração
    //Post - insere valores na conta do cliente
    @PostMapping(path = "/zupcash/deposito/{id}/{contacorrente}/{valor}" )
    @ResponseStatus(HttpStatus.CREATED)
    public Transacoes depositarDinheiro(@PathVariable Long id, @PathVariable String contacorrente, @PathVariable BigDecimal valor) {

        return transacoesService.depositar(id,contacorrente,valor);

    }

    //Endpoint de insercao e alteração
    //Post - remove valores na conta do cliente
    @PostMapping(path = "/zupcash/saque/{id}/{contacorrente}/{valor}" )
    @ResponseStatus(HttpStatus.CREATED)
    public Transacoes sacarDinheiro(@PathVariable Long id, @PathVariable String contacorrente, @PathVariable BigDecimal valor) {

        return transacoesService.sacar(id,contacorrente,valor);
    }

}
