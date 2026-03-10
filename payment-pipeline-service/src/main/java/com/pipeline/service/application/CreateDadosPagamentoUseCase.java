package com.pipeline.service.application;

import com.pipeline.service.domain.DadosPagamentoCollection;
import com.pipeline.service.domain.request.CreateDadosPagamentoRequest;

public interface CreateDadosPagamentoUseCase {

    DadosPagamentoCollection create(CreateDadosPagamentoRequest dados);
}
