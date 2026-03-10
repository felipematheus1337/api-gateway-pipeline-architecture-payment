package com.pipeline.service.application.workflow.context;


import com.pipeline.service.domain.DadosPagamentoCollection;
import com.pipeline.service.domain.request.CreateDadosPagamentoRequest;

public class CreateDadosPagamentoContext implements DadosPagamentoContext {

    private CreateDadosPagamentoRequest request;
    private DadosPagamentoCollection collection;

    public CreateDadosPagamentoContext(CreateDadosPagamentoRequest request) {
        this.request = request;
    }
}
