package br.com.treinamento;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import br.com.dimed.arch.DimedServicesRunner;

@EnableAutoConfiguration
@EnableScheduling
@ComponentScan(basePackages = "br.com.treinamento")
public class Application {
    public static void main(String[] args) {
        new DimedServicesRunner(Application.class).run(args);
    }
}
