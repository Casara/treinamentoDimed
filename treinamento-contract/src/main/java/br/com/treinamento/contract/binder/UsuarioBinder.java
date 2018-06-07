package br.com.treinamento.contract.binder;

import br.com.treinamento.contract.model.Usuario;
import br.com.treinamento.model.UsuarioFunctionalModel;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioBinder {

    public static UsuarioFunctionalModel bindTo(Usuario usuario) {
        return UsuarioFunctionalModel.builder()
                .nome(usuario.getNome())
                .dataNascimento(usuario.getDataNascimento())
                .endereco(usuario.getEndereco())
                .cpf(usuario.getCpf())
                .build();
    }

    public static Usuario bindFrom(UsuarioFunctionalModel usuario) {
        return Usuario.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .dataNascimento(usuario.getDataNascimento())
                .endereco(usuario.getEndereco())
                .cpf(usuario.getCpf())
                .build();
    }

    public static List<Usuario> bindFrom(List<UsuarioFunctionalModel> usuarios) {
        return usuarios.stream().map(UsuarioBinder::bindFrom).collect(Collectors.toList());
    }
}
