package com.gerenciador.tarefas.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AtualizarTarefaResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private String criador;
    private int quantidadeHorasEstimadas;
    private String status;
    private String responsavel;
    private Integer quantidadeHorasRealizada;
}
