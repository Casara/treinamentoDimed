package br.com.treinamento.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioFuncionalModel {

    private int id;

    private String nome;

    private LocalDateTime dataNascimento;

    private String cpf;

    private String endereco;

}
