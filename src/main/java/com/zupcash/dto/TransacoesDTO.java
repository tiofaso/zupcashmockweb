package com.zupcash.dto;

import com.zupcash.model.ContaCorrente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransacoesDTO {
    private String numeroContaDto;
    private BigDecimal valorDto;
    private String servicoDto;
}
