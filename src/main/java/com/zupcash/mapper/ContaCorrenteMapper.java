package com.zupcash.mapper;

import com.zupcash.dto.ContaCorrenteDto;
import com.zupcash.model.ContaCorrente;
import org.springframework.stereotype.Component;

@Component
public class ContaCorrenteMapper {
    public ContaCorrenteDto toDto(ContaCorrente contaCorrente) {
        ContaCorrenteDto dto = new ContaCorrenteDto();

        dto.setIdDto(contaCorrente.getId());
        dto.setNumeroContaDto(contaCorrente.getNumeroConta());
        dto.setValorAtualDto(contaCorrente.getValorAtual().toString());
        dto.setAgenciaDto(contaCorrente.getAgencia());
        dto.setNomeUsuarioDto(contaCorrente.getNomeUsuario());
        dto.setValoFinalDto(contaCorrente.getValorFinal().toString());
        dto.setStatusContaDto(contaCorrente.getStatusConta().toString());
        return dto;
    }
}
