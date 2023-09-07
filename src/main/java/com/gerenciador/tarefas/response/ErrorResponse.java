package com.gerenciador.tarefas.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private String status; // 400 - BAD REQUEST
    private List<Map<String, String>> errors; // campo // descricao
}
