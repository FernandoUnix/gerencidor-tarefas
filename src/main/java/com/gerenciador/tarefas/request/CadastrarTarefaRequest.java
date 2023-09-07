package com.gerenciador.tarefas.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CadastrarTarefaRequest {

    @NotBlank(message = "{cadastrar.tarefa.request.titulo.obrigatorio}")
    private String titulo;

    @Length(max = 150, message = "{cadastrar.tarefa.request.descricao.limite}")
    private String descricao;

    @NotNull(message = "{cadastrar.tarefa.request.criadorId.obrigatorio}")
    private Long criadorId;

    @NotNull(message = "{cadastrar.tarefa.request.quantidadeHorasEstimadas.obrigatorio}")
    private Integer quantidadeHorasEstimadas;
}
