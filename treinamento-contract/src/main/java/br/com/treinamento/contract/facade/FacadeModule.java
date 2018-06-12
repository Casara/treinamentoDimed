package br.com.treinamento.contract.facade;

import br.com.treinamento.service.UsuariosService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacadeModule {
    @Bean
    public UsuarioFacade usuariosFacade(UsuariosService service) {
        return new UsuarioFacade(service);
    }
}
