package br.com.treinamento.exceptions;

import br.com.dimed.arch.jersey.exceptions.ApiException;

import javax.ws.rs.core.Response;

public class NenhumResultadoEncontrado extends ApiException {

    private static final String DEFAULT_MESSAGE = "Nenhum resultado encontrado.";

    public NenhumResultadoEncontrado() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public String getCode() {
        return "404";
    }

    @Override
    public String getField() {
        return null;
    }

    @Override
    public String getDeveloperMessage() {
        return null;
    }

    @Override
    public Response.Status getHttpStatus() {
        return Response.Status.NOT_FOUND;
    }

}
