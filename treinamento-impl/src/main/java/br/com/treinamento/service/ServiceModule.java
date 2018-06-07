package br.com.treinamento.service;

import br.com.treinamento.database.UsuariosData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceModule {

    @Bean
    public UsuariosService usuariosService(UsuariosData usuariosData) {
        return new UsuariosService(usuariosData);
    }
}
