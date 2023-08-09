package com.zupcash.repository;

import com.zupcash.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {
    //@Query("SELECT cc FROM ContaCorrente cc WHERE cc.numeroConta = :contacorrente ")
    //public Optional<ContaCorrente> buscaContaCorrente(@Param("contacorrente") String contacorrente);
    public Optional<ContaCorrente> findByNumeroConta(String numeroConta);
}
