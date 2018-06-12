package br.com.treinamento.contract.facade;

import br.com.treinamento.contract.binder.UsuarioBinder;
import br.com.treinamento.contract.model.Usuario;
import br.com.treinamento.service.UsuariosService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UsuarioFacade {
    private UsuariosService usuariosService;

    public List<Usuario> listUsuarios() {
        return UsuarioBinder.bindFrom(usuariosService.getUsuarios());
    }

    public Usuario getUsuario(int id) {
        return UsuarioBinder.bindFrom(usuariosService.getUsuario(id));
    }

    public int insertUsuario(Usuario usuario) {
        return usuariosService.insertUsuario(UsuarioBinder.bindTo(usuario));
    }

    public void updateUsuario(Usuario usuario) {
        usuariosService.updateUsuario(UsuarioBinder.bindTo(usuario));
    }

    public void deleteUsuario(int id) {
        usuariosService.deleteUsuario(id);
    }
}
