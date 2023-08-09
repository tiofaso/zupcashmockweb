package com.zupcash.mapper;

import com.zupcash.dto.TransacoesDTO;
import com.zupcash.model.Transacoes;
import org.springframework.stereotype.Component;

@Component
public class TransacoesMapper {
    public TransacoesDTO toDto(Transacoes transacoes) {
        TransacoesDTO dto = new TransacoesDTO();

        dto.setNumeroContaDto(transacoes.getNumeroConta());
        dto.setValorDto(transacoes.getValor());
        dto.setServicoDto(transacoes.getServico());
        return dto;
    }
}
