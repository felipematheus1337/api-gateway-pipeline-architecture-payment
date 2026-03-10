package com.pipeline.service.application;

import com.pipeline.service.domain.DadosPagamentoCollection;
import com.pipeline.service.domain.request.CreateDadosPagamentoRequest;

public interface CreateDadosPagamentoUseCase {

    void create(CreateDadosPagamentoRequest dados);
}
