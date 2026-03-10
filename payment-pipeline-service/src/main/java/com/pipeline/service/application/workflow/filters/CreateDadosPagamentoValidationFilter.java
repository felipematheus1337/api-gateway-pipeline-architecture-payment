package com.pipeline.service.application.workflow.filters;

import com.pipeline.service.application.workflow.context.CreateDadosPagamentoContext;
import com.pipeline.service.application.workflow.exceptions.PipelineFiltersException;
import com.pipeline.service.domain.request.CreateDadosPagamentoRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreateDadosPagamentoValidationFilter implements Filter<CreateDadosPagamentoContext> {

    @Override
    public void apply(CreateDadosPagamentoContext createDadosPagamentoContext) {
        CreateDadosPagamentoRequest request = createDadosPagamentoContext.getRequest();
        if (request == null)
            throw new PipelineFiltersException("Workflow cant continue with a invalid request");

        if (request.cpf() == null || request.cpf().isEmpty())
            throw new PipelineFiltersException("Not a valid CPF.");

        if (request.paymentType() == null || !request.paymentType().isValid())
            throw new PipelineFiltersException("Not a valid payment type.");

        if (request.total().compareTo(BigDecimal.ZERO) > 0)
            throw new PipelineFiltersException("Total must have to be greater than zero.");

    }
}
