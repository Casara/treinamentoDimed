package br.com.treinamento.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioFunctionalModel {
    private int id;
    private String nome;
    private LocalDateTime dataNascimento;
    private String cpf;
    private String endereco;
}
