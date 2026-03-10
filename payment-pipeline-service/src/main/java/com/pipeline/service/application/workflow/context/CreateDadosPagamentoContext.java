package com.pipeline.service.application.workflow.context;


import com.pipeline.service.domain.DadosPagamentoCollection;
import com.pipeline.service.domain.request.CreateDadosPagamentoRequest;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CreateDadosPagamentoContext implements DadosPagamentoContext {

    private CreateDadosPagamentoRequest request;
    private DadosPagamentoCollection collection;

    public CreateDadosPagamentoContext(CreateDadosPagamentoRequest request) {
        this.request = request;
    }
}
