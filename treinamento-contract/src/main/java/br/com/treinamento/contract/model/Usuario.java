package br.com.treinamento.contract.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String dataNascimento; // java.time.LocalDateTime

    @NotEmpty
    private String cpf;

    @NotEmpty
    private String endereco;
}
