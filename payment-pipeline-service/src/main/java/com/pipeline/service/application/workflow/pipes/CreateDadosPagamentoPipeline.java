package com.pipeline.service.application.workflow.pipes;

import com.pipeline.service.application.workflow.context.CreateDadosPagamentoContext;
import com.pipeline.service.application.workflow.context.DadosPagamentoContext;
import com.pipeline.service.application.workflow.filters.*;
import com.pipeline.service.domain.request.CreateDadosPagamentoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateDadosPagamentoPipeline {

    private final List<Filter<CreateDadosPagamentoContext>> steps;

    public CreateDadosPagamentoPipeline(
            CreateDadosPagamentoValidationFilter vf,
            CreateDadosPagamentoPaymentFilter pf,
            CreateDadosPagamentoCollectionTransformFilter tf,
            CreateDadosPagamentoPersistenceFilter ps,
            CreateDadosPagamentoNotificationFilter nf
            ) {
        this.steps = List.of(vf, pf, tf, ps, nf);
    }

    public void execute(CreateDadosPagamentoRequest request) {
      log.info("::: Request Receive -> {}", request.toString());
      var ctx = new CreateDadosPagamentoContext(request);
      for(var step: steps) {
          log.info("::: Applying filter -> {} ", step.getClass().getName());
          step.apply(ctx);
      }
    }

}
