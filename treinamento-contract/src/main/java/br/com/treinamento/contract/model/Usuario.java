package br.com.treinamento.contract.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    private Integer id;

    @NotEmpty
    private String nome;

    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dataNascimento;

    @NotEmpty
    private String cpf;

    @NotEmpty
    private String endereco;

}
