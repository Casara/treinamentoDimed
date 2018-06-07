package br.com.treinamento.contract.facade;

import br.com.treinamento.contract.binder.UsuarioBinder;
import br.com.treinamento.contract.model.Usuario;
import br.com.treinamento.service.UsuariosService;

import java.util.List;

public class UsuarioFacade {

    private UsuariosService usuariosService;

    public  UsuarioFacade(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    public List<Usuario> listUsuarios() {
        return UsuarioBinder.bindFrom(usuariosService.getUsuarios());
    }

    public Usuario getUsuario(Long id) {
        return UsuarioBinder.bindFrom(usuariosService.getUsuario(id));
    }

    public Usuario insertUsuario(Usuario usuario) {
        return UsuarioBinder.bindFrom(usuariosService.insertUsuario(UsuarioBinder.bindTo(usuario)));
    }

    public Usuario updateUsuario(Usuario usuario) {
        return UsuarioBinder.bindFrom(usuariosService.updateUsuario(UsuarioBinder.bindTo(usuario)));
    }

    public void deleteUsuario(Long id) {
        usuariosService.deleteUsuario(id);
    }
}