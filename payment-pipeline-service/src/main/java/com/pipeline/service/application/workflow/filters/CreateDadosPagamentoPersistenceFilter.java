package com.pipeline.service.application.workflow.filters;

import com.pipeline.service.application.workflow.context.CreateDadosPagamentoContext;
import com.pipeline.service.infra.repository.DadosPagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CreateDadosPagamentoPersistenceFilter implements Filter<CreateDadosPagamentoContext> {

    private final DadosPagamentoRepository repository;

    @Override
    @Transactional
    public void apply(CreateDadosPagamentoContext ctx) {
        repository.save(ctx.getCollection());

    }
}
