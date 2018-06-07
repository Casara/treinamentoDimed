package br.com.treinamento.service;

import br.com.treinamento.database.UsuariosData;
import br.com.treinamento.model.UsuarioFunctionalModel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UsuariosService {

    private UsuariosData usuariosData;

    public UsuariosService(UsuariosData usuariosData) {
        this.usuariosData = usuariosData;
    }

    public List<UsuarioFunctionalModel> getUsuarios() {
        return usuariosData.selectUsuarios();
    }

    public UsuarioFunctionalModel getUsuario(Long id) {
        return usuariosData.selectUsuario(id);
    }

    public UsuarioFunctionalModel insertUsuario(UsuarioFunctionalModel usuarioFunctionalModel) {
        return usuariosData.insertUsuario(usuarioFunctionalModel);
    }

    public UsuarioFunctionalModel updateUsuario(UsuarioFunctionalModel usuarioFunctionalModel) {
        return usuariosData.updateUsuario(usuarioFunctionalModel);
    }

    public void deleteUsuario(Long id) {
        usuariosData.deleteUsuario(id);
    }
}