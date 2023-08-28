package com.zupcash;

import com.zupcash.controller.ContaCorrenteController;
import com.zupcash.dto.ContaCorrenteDTO;
import com.zupcash.mapper.ContaCorrenteMapper;
import com.zupcash.model.ContaCorrente;
import com.zupcash.service.ContaCorrenteService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(ContaCorrenteController.class)
public class ContaCorrenteControllerTest {
    @MockBean
    private ContaCorrenteService contaCorrenteService;

    @MockBean
    private ContaCorrenteMapper contaCorrenteMapper;

    @MockBean
    ContaCorrenteDTO contaCorrenteDTO;

    @Autowired
    private MockMvc mockMvc;

    @Test //Teste do endpoint de busca de clientes
    public void buscaClientesTest() throws Exception {
        BigDecimal valorAtualTest = BigDecimal.valueOf(0.00);
        BigDecimal valorFinalTest = BigDecimal.valueOf(0.00);

        when(contaCorrenteService.buscaTodosClientes())
                .thenReturn(List.of(new ContaCorrente(1L,"065667-3","0022","lizmiranda",valorAtualTest,valorFinalTest,true)));

        mockMvc
                .perform(MockMvcRequestBuilders.get("/zupcash/clientes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(("$")).isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].numeroConta").value("065667-3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].agencia").value("0022"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nomeUsuario").value("lizmiranda"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].valorAtual").value(0.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].valorFinal").value(0.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").value(true));
    }

}
