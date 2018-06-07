package br.com.treinamento.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioFunctionalModel {
    private Long id;
    private String nome;
    private String dataNascimento; // java.time.LocalDateTime
    private String cpf;
    private String endereco;
}
