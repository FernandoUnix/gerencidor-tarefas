package com.gerenciador.tarefas.config;

import com.gerenciador.tarefas.filter.AutenticacaoFiltro;
import com.gerenciador.tarefas.filter.LoginFiltro;
import com.gerenciador.tarefas.permissoes.PermissaoEnum;
import com.gerenciador.tarefas.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {

        http.csrf(crsf -> crsf.disable())
                .authorizeHttpRequests( auth -> {
                    auth.requestMatchers("/login").permitAll()
                            .requestMatchers(HttpMethod.GET, "/teste-api").permitAll()
                            .requestMatchers(HttpMethod.GET, "/teste-api-bem-vindo").hasAuthority(PermissaoEnum.ADMINISTRADOR.toString())
                            .requestMatchers(HttpMethod.GET, "/usuarios").hasAuthority(PermissaoEnum.USUARIO.toString())
                            .requestMatchers(HttpMethod.POST, "/usuarios").hasAuthority(PermissaoEnum.ADMINISTRADOR.toString())
                            .requestMatchers(HttpMethod.POST, "/gerenciador-tarefas").hasAuthority(PermissaoEnum.ADMINISTRADOR.toString())
                            .anyRequest()
                            .authenticated();
            });

        http.addFilterBefore(new LoginFiltro("/login", authenticationConfiguration.getAuthenticationManager()), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new AutenticacaoFiltro(), UsernamePasswordAuthenticationFilter.class);

       return http.build();
    }
}