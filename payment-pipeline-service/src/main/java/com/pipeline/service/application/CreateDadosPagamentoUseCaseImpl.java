package com.pipeline.service.application;

import com.pipeline.service.application.workflow.pipes.CreateDadosPagamentoPipeline;
import com.pipeline.service.domain.DadosPagamentoCollection;
import com.pipeline.service.domain.request.CreateDadosPagamentoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateDadosPagamentoUseCaseImpl implements CreateDadosPagamentoUseCase {

    private final CreateDadosPagamentoPipeline pipeline;

    @Override
    public void create(CreateDadosPagamentoRequest dados) {
        log.info("Starting the pipeline workflow...");
        pipeline.execute(dados);
        log.info("Finished the pipeline workflow.");
    }
}
