package com.zupcash.service;

import com.zupcash.model.ContaCorrente;
import com.zupcash.repository.ContaCorrenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContaCorrenteService {

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;


    //Método que busca todos os clientes do banco
    public List<ContaCorrente> buscaTodosClientes(){
        return contaCorrenteRepository.findAll();
    }

    //Método para inserir um novo cliente no banco
    public ContaCorrente cadastraCliente(ContaCorrente contaCorrente) {
        return contaCorrenteRepository.save(contaCorrente);
    }

    //Método para buscar um cliente por ID no banco
    public Optional<ContaCorrente> buscaId(Long id) {
        return contaCorrenteRepository.findById(id);
    }

    public Optional<ContaCorrente> buscaContaCorrente(String contacorrente) {
        //return contaCorrenteRepository.buscaContaCorrente(contacorrente);
        return contaCorrenteRepository.findByNumeroConta(contacorrente);
    }

    //Método para desativar/delete conta do cliente
    public ContaCorrente deletaConta(String contacorrente){
        ContaCorrente fechaConta = buscaContaCorrente(contacorrente).orElse(null);

        if(fechaConta != null){
           fechaConta.setStatusConta(false);
        }
        return  contaCorrenteRepository.save(fechaConta);
    }

}

