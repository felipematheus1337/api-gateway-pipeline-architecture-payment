package com.pipeline.service.application.workflow.filters;

import com.pipeline.service.application.workflow.context.CreateDadosPagamentoContext;
import org.springframework.stereotype.Component;

@Component
public class CreateDadosPagamentoCollectionTransformFilter implements Filter<CreateDadosPagamentoContext> {

    @Override
    public void apply(CreateDadosPagamentoContext ctx) {
        ctx.transformToCollection();
    }
}
