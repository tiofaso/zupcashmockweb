package com.zupcash.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_contacorrente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaCorrente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 8, nullable = false)
    private String numeroConta;
    @Column(length = 4, nullable = false)
    private String agencia;
    @Column(length = 20, nullable = false)
    private String nomeUsuario;
    @Column(nullable = false)
    private BigDecimal valorAtual;
    @Column(nullable = false)
    private BigDecimal valorFinal;
    @Column(nullable = false)
    private Boolean statusConta;

}
