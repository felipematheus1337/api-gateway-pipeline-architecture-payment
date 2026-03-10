package com.pipeline.service.application;

import com.pipeline.service.domain.DadosPagamentoCollection;
import com.pipeline.service.domain.request.CreateDadosPagamentoRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateDadosPagamentoUseCaseImpl implements CreateDadosPagamentoUseCase{

    @Override
    public DadosPagamentoCollection create(CreateDadosPagamentoRequest dados) {
        return null;
    }
}
