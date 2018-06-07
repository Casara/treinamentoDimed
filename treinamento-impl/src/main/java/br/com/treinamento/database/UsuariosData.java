package br.com.treinamento.database;

import br.com.treinamento.common.typehandler.LocalDateTimeTypeHandler;
import br.com.treinamento.model.UsuarioFunctionalModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UsuariosData {
    @Select("SELECT * FROM USUARIOS")
    @Results(value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "nome", column = "NOME"),
            @Result(property = "dataNascimento", column = "DATA_NASCIMENTO", typeHandler = LocalDateTimeTypeHandler.class),
            @Result(property = "cpf", column = "CPF"),
            @Result(property = "endereco", column = "ENDERECO"),
    })
    List<UsuarioFunctionalModel> selectUsuarios();

    @Select("SELECT * FROM USUARIOS WHERE ID = #{id}")
    @Results(value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "nome", column = "NOME"),
            @Result(property = "dataNascimento", column = "DATA_NASCIMENTO", typeHandler = LocalDateTimeTypeHandler.class),
            @Result(property = "cpf", column = "CPF"),
            @Result(property = "endereco", column = "ENDERECO")
    })
    UsuarioFunctionalModel selectUsuario(int id);

    @Insert("INSERT INTO USUARIOS (ID, NOME, DATA_NASCIMENTO, CPF, ENDERECO) VALUES (" +
            "    #{id}," +
            "    #{nome}," +
            "    #{dataNascimento, typeHandler = br.com.treinamento.common.typehandler.LocalDateTimeTypeHandler}," +
            "    #{cpf}," +
            "    #{endereco}" +
            ")")
    UsuarioFunctionalModel insertUsuario(UsuarioFunctionalModel usuarioFunctionalModel);

    @Update("UPDATE USUARIOS SET" +
            "    NOME = #{nome}," +
            "    DATA_NASCIMENTO = #{dataNascimento, typeHandler = br.com.treinamento.common.typehandler.LocalDateTimeTypeHandler}," +
            "    CPF = #{cpf}," +
            "    ENDERECO = #{endereco}," +
            " WHERE ID = #{id}")
    UsuarioFunctionalModel updateUsuario(UsuarioFunctionalModel usuarioFunctionalModel);

    @Delete("DELETE FROM USUARIOS WHERE ID = #{id}")
    void deleteUsuario(int id);
}
