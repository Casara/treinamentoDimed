package br.com.treinamento.contract.binder;

import br.com.treinamento.contract.model.Usuario;
import br.com.treinamento.model.UsuarioFuncionalModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioBinder {
    public static UsuarioFuncionalModel bindTo(Usuario usuario) {
        return UsuarioFuncionalModel.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .dataNascimento(LocalDateTime.parse(usuario.getDataNascimento() + "T03:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .endereco(usuario.getEndereco())
                .cpf(usuario.getCpf())
                .build();
    }

    public static Usuario bindFrom(UsuarioFuncionalModel usuario) {
        return Usuario.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .dataNascimento(usuario.getDataNascimento().format(DateTimeFormatter.ISO_LOCAL_DATE))
                .endereco(usuario.getEndereco())
                .cpf(usuario.getCpf())
                .build();
    }

    public static List<Usuario> bindFrom(List<UsuarioFuncionalModel> usuarios) {
        return usuarios.stream().map(UsuarioBinder::bindFrom).collect(Collectors.toList());
    }
}
