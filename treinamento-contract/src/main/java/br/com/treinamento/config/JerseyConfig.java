package br.com.treinamento.config;

import br.com.dimed.arch.jersey.DefaulJerseyConfig;
import br.com.treinamento.contract.RestEndpoint;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@Api("/usuarios")
@ApplicationPath("treinamento")
public class JerseyConfig extends DefaulJerseyConfig {

    public JerseyConfig() {
        super();
        register(RestEndpoint.class);
    }

}
