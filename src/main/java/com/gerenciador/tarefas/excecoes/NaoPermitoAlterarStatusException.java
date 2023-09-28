package com.gerenciador.tarefas.excecoes;

public class NaoPermitoAlterarStatusException extends RuntimeException {

    public NaoPermitoAlterarStatusException(){
        super();
    }

    public NaoPermitoAlterarStatusException(String mensagem){
        super(mensagem);
    }
}
