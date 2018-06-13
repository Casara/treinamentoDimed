package br.com.treinamento.exceptions;

import br.com.dimed.arch.jersey.exceptions.ApiException;

import javax.ws.rs.core.Response;

public class ChavePrimariaDuplicada extends ApiException {

    private static final String DEFAULT_MESSAGE = "Este valor já está em uso por outro registro.";

    public ChavePrimariaDuplicada() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public String getCode() {
        return "002";
    }

    @Override
    public String getField() {
        return "id";
    }

    @Override
    public String getDeveloperMessage() {
        return null;
    }

    @Override
    public Response.Status getHttpStatus() {
        return Response.Status.BAD_REQUEST;
    }

}
