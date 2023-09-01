package com.gerenciador.tarefas.repository;

import com.gerenciador.tarefas.entity.Role;
import com.gerenciador.tarefas.permissoes.PermissaoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    Role findByNome(PermissaoEnum nome);
}
