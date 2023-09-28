package com.gerenciador.tarefas.repository;

import com.gerenciador.tarefas.entity.Tarefa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenciadorTarefasRepository extends JpaRepository<Tarefa, Long> {

    Tarefa findByTituloOrDescricao(String titulo, String descricao);
    Page<Tarefa> findByTituloContainingOrderByDataAtualizacaoDesc(String titulo, Pageable pegeable);
    Page<Tarefa> findAllByOrderByDataAtualizacaoDesc(Pageable pegeable);
}
