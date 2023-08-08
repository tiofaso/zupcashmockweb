package com.zupcash.controller;

import com.zupcash.model.ContaCorrente;
import com.zupcash.service.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class ContaCorrenteController {
    @Autowired
    ContaCorrenteService contaCorrenteService;

    //Endpoint de consulta
    //Get - lista todos os clientes da DB
    @GetMapping(path = "/zupcash/clientes")
    public List<ContaCorrente> buscaClientes(){
        return contaCorrenteService.buscaTodosClientes();
    }

    //Endpoint de inserção
    //Post - insere um novo cliente na DB
    @PostMapping(path = "/zupcash/cadastra")
    @ResponseStatus(HttpStatus.CREATED)
    public ContaCorrente cadastraNovoCliente(@RequestBody ContaCorrente contaCorrente) {
        return contaCorrenteService.cadastraCliente(contaCorrente);
    }

    //Endpoint de consulta individual
    //Get - busca um cliente específico na DB
    @GetMapping(path = "/zupcash/busca/{id}")
    public Optional<ContaCorrente> buscaClienteId(@PathVariable Long id) {
        return contaCorrenteService.buscaId(id);
    }

    //Endpoint de alteração
    //Post - desabilita a conta do cliente/delete
    @PostMapping(path = "zupcash/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletarConta(@PathVariable Long id) {
        contaCorrenteService.deletaConta(id);

    }
}
