package br.com.treinamento.contract;

import br.com.treinamento.contract.facade.UsuarioFacade;
import br.com.treinamento.contract.model.Usuario;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/treinamento")
@Api(value = "treinamento", description = "Service Treinamento", produces = MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestEndpoint {

    @Autowired
    UsuarioFacade usuarioFacade;

    @Context
    UriInfo uriInfo;

    @GET
    @Path("/usuarios")
    @ApiOperation(value = "Lista os usuários cadastrados", response = Usuario.class, responseContainer = "List")
    public List<Usuario> listUsuarios() {
        return usuarioFacade.listUsuarios();
    }

    @GET
    @Path("/usuarios/{id}")
    @ApiOperation(value = "Busca usuário pelo identificador", response = Usuario.class)
    public Usuario getUsuario(@ApiParam(value = "Identificador do usuário", required = true) @PathParam("id") Long id) {
        return usuarioFacade.getUsuario(id);
    }

    @POST
    @Path("/usuarios")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Cadastra um novo usuário")
    @ApiResponses({@ApiResponse(code = 201, message = "Usuário cadastrado")})
    public Response createUsuario(@ApiParam(value = "Novo usuário", required = true) @NotNull @Valid Usuario usuario) {
        String addedId = String.valueOf(usuarioFacade.insertUsuario(usuario).getId());
        return Response.created(uriInfo.getAbsolutePathBuilder().path(addedId).build()).build();
    }

    @PUT
    @Path("/usuarios/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Atualiza o cadastro de um usuário")
    @ApiResponses({@ApiResponse(code = 203, message = "Usuário atualizado")})
    public Response updateUsuario(
            @ApiParam(value = "Identificador do usuário", required = true) @PathParam("id") Long id,
            @NotNull @Valid Usuario usuario
    ) {
        usuario.setId(id);
        usuarioFacade.updateUsuario(usuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/usuarios/{id}")
    @ApiOperation(value = "Exclui o cadastro de um usuário")
    @ApiResponses({@ApiResponse(code = 204, message = "Usuário excluído")})
    public Response deleteUser(@ApiParam(value = "Identificador do usuário", required = true) @PathParam("id") Long id) {
        usuarioFacade.deleteUsuario(id);
        return Response.noContent().build();
    }
}