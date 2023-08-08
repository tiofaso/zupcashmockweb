package com.zupcash.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "tb_transacoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "numeroConta", referencedColumnName = "numeroConta", insertable = false, updatable = false)
    private ContaCorrente contaCorrente;

    private String numeroConta;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column(length = 8, nullable = false)
    private String servico;

}
