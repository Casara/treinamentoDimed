package br.com.treinamento.service;

import br.com.treinamento.database.UsuariosData;
import br.com.treinamento.exceptions.ChavePrimariaDuplicada;
import br.com.treinamento.exceptions.MuitosResultados;
import br.com.treinamento.exceptions.NenhumResultadoEncontrado;
import br.com.treinamento.model.UsuarioFuncionalModel;
import lombok.AllArgsConstructor;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

@AllArgsConstructor
public class UsuariosService {
    private UsuariosData usuariosData;

    public List<UsuarioFuncionalModel> getUsuarios() {
        return usuariosData.selectUsuarios();
    }

    public UsuarioFuncionalModel getUsuario(int id) {
        try {
            UsuarioFuncionalModel usuarioFuncionalModel = usuariosData.selectUsuario(id);

            if (usuarioFuncionalModel == null) throw new NenhumResultadoEncontrado();

            return usuarioFuncionalModel;
        } catch (MyBatisSystemException e) {
            throw new MuitosResultados();
        }
    }

    public int insertUsuario(UsuarioFuncionalModel usuarioFuncionalModel) {
        try {
            return usuariosData.insertUsuario(usuarioFuncionalModel);
        } catch (DuplicateKeyException e) {
            throw new ChavePrimariaDuplicada();
        }
    }

    public void updateUsuario(UsuarioFuncionalModel usuarioFuncionalModel) {
        usuariosData.updateUsuario(usuarioFuncionalModel);
    }

    public void deleteUsuario(int id) {
        usuariosData.deleteUsuario(id);
    }
}
