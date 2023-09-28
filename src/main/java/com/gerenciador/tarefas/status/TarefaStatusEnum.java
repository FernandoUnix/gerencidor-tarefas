package com.gerenciador.tarefas.status;

/*
1 - Não permitir deletar tarefa se o status for diferente de CRIADA
2 - Não deixar mover a tarefa para FINALIZADA se a mesma estiver em CRIADA
3 - Não deixar mover a tarefa para FINALIZADA se a mesma estiver em BLOQUEADA
4 - Uma vez finalizada a Tarefa não pode mudar de status e nem ser deletada
5 - Se uma Tarefa tiver a mesma descrição ou titulo informar que já existe uma tarefa criada
 */
public enum TarefaStatusEnum {
    CRIADA, PROGRESSO, BLOQUEADA, FINALIZADA
}
