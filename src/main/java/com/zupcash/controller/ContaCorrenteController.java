package com.zupcash.controller;

import com.zupcash.dto.ContaCorrenteDTO;
import com.zupcash.mapper.ContaCorrenteMapper;
import com.zupcash.model.ContaCorrente;
import com.zupcash.service.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ContaCorrenteController {
    @Autowired
    ContaCorrenteService contaCorrenteService;

    @Autowired
    ContaCorrenteMapper contaCorrenteMapper;

    //Endpoint de consulta
    //Get - lista todos os clientes da DB
    @GetMapping(path = "/zupcash/clientes")
    public ResponseEntity<List<ContaCorrenteDTO>> buscaClientes() {
        List<ContaCorrente> contasCorrente = contaCorrenteService.buscaTodosClientes();
        return ResponseEntity.ok(contasCorrente.stream().map(contaCorrenteMapper::toDto).collect(Collectors.toList()));
    }

    //Endpoint de inserção
    //Post - insere um novo cliente na DB
    @PostMapping(path = "/zupcash/cadastra")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContaCorrenteDTO> cadastraNovoCliente(@RequestBody ContaCorrente contaCorrente) {
        ContaCorrente contasCorrente = contaCorrenteService.cadastraCliente(contaCorrente);
        return new ResponseEntity<>(contaCorrenteMapper.toDto(contasCorrente), HttpStatus.CREATED);
    }

    //Endpoint de consulta individual
    //Get - busca um cliente específico na DB
    @GetMapping(path = "/zupcash/busca/{contacorrente}")
    public ResponseEntity<Optional<ContaCorrenteDTO>> buscaClienteId(@PathVariable String contacorrente) {
        Optional<ContaCorrente> contasCorrenteOptional = contaCorrenteService.buscaContaCorrente(contacorrente);

        ContaCorrente contasCorrente = contasCorrenteOptional.get();
        return ResponseEntity.ok(Optional.ofNullable(contaCorrenteMapper.toDto(contasCorrente)));
    }

    //Endpoint de alteração
    //Post - desabilita a conta do cliente/delete
    @PostMapping(path = "zupcash/delete/{contacorrente}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletarConta(@PathVariable String contacorrente) {
        ContaCorrente contasCorrente = contaCorrenteService.deletaConta(contacorrente);
        contaCorrenteMapper.toDto(contasCorrente);
    }
}
