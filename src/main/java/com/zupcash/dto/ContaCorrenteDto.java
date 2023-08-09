package com.zupcash.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaCorrenteDto {
    private long idDto;
    private String numeroContaDto;
    private String valorAtualDto;
    private String agenciaDto;
    private String nomeUsuarioDto;
    private String valoFinalDto;
    private String statusContaDto;

}
