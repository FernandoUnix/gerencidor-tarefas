package com.gerenciador.tarefas.service;

import com.gerenciador.tarefas.entity.Usuario;
import com.gerenciador.tarefas.repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class UsuarioAutenticadoService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       Usuario usuario = iUsuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário "+ username + " não foi encontrado"));

       List<SimpleGrantedAuthority> roles = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNome().toString()))
                .toList();

        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
