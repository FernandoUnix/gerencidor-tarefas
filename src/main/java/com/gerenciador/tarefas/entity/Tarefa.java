package com.gerenciador.tarefas.entity;

import com.gerenciador.tarefas.status.TarefaStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "tarefas")
@Data
@Getter
@Setter
@Builder
public class Tarefa implements Serializable {

   private static final long serialVersionUID = 1L;

   public Tarefa() {
   }

   public Tarefa(Long id, String titulo, String descricao, TarefaStatusEnum status, Usuario responsavel, Usuario criador, int quantidadeHorasEstimadas, Integer quantidadeHorasRealizada, LocalTime dataCadasto, LocalTime dataAtualizacao) {
      this.id = id;
      this.titulo = titulo;
      this.descricao = descricao;
      this.status = status;
      this.responsavel = responsavel;
      this.criador = criador;
      this.quantidadeHorasEstimadas = quantidadeHorasEstimadas;
      this.quantidadeHorasRealizada = quantidadeHorasRealizada;
      this.dataCadasto = dataCadasto;
      this.dataAtualizacao = dataAtualizacao;
   }

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;

   @Column(nullable = false)
   private String titulo;

   @Column(nullable = false)
   private String descricao;

   @Column(nullable = false)
   @Enumerated(EnumType.STRING)
   private TarefaStatusEnum status;

   @Column
   private Usuario responsavel;

   @Column(nullable = false)
   private Usuario criador;

   @Column(nullable = false)
   private int quantidadeHorasEstimadas;

   @Column
   private Integer quantidadeHorasRealizada;

   @Column
   @CreationTimestamp
   private LocalTime dataCadasto;

   @Column
   @UpdateTimestamp
   private LocalTime dataAtualizacao;
}
