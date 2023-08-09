package com.zupcash.controller;

import com.zupcash.dto.ContaCorrenteDTO;
import com.zupcash.mapper.ContaCorrenteMapper;
import com.zupcash.model.ContaCorrente;
import com.zupcash.service.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<ContaCorrenteDTO> buscaClientes(){
        List<ContaCorrente> contasCorrente = contaCorrenteService.buscaTodosClientes();
        return contasCorrente.stream().map(contaCorrenteMapper::toDto).collect(Collectors.toList());
    }

    //Endpoint de inserção
    //Post - insere um novo cliente na DB
    @PostMapping(path = "/zupcash/cadastra")
    @ResponseStatus(HttpStatus.CREATED)
    public ContaCorrenteDTO cadastraNovoCliente(@RequestBody ContaCorrente contaCorrente) {
        ContaCorrente contasCorrente = contaCorrenteService.cadastraCliente(contaCorrente);
        return contaCorrenteMapper.toDto(contasCorrente);
    }

    //Endpoint de consulta individual
    //Get - busca um cliente específico na DB
    @GetMapping(path = "/zupcash/busca/{id}")
    public Optional<ContaCorrenteDTO> buscaClienteId(@PathVariable Long id) {
        Optional<ContaCorrente> contasCorrenteOptional = contaCorrenteService.buscaId(id);

        ContaCorrente contasCorrente = contasCorrenteOptional.get();
        return Optional.ofNullable(contaCorrenteMapper.toDto(contasCorrente));

    }

    //Endpoint de alteração
    //Post - desabilita a conta do cliente/delete
    @PostMapping(path = "zupcash/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletarConta(@PathVariable Long id) {
        ContaCorrente contasCorrente = contaCorrenteService.deletaConta(id);
        contaCorrenteMapper.toDto(contasCorrente);
    }
}
