package com.zupcash.mapper;

import com.zupcash.dto.ContaCorrenteDTO;
import com.zupcash.model.ContaCorrente;
import org.springframework.stereotype.Component;

@Component
public class ContaCorrenteMapper {
    public ContaCorrenteDTO toDto(ContaCorrente contaCorrente) {
        ContaCorrenteDTO dto = new ContaCorrenteDTO();

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
