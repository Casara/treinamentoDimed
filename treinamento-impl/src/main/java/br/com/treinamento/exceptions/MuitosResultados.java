package br.com.treinamento.exceptions;

import br.com.dimed.arch.jersey.exceptions.ApiException;

import javax.ws.rs.core.Response;

public class MuitosResultados extends ApiException {

    final static String DEFAULT_MESSAGE = "Muitos registros encontrados para essa requisição.";

    public MuitosResultados() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public String getCode() {
        return "001";
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
        return Response.Status.BAD_REQUEST;
    }
}
