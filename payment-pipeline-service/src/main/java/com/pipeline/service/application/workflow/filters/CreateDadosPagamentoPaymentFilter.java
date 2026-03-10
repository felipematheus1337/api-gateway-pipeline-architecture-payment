package com.pipeline.service.application.workflow.filters;

import com.pipeline.service.application.strategies.PaymentCreditoStrategy;
import com.pipeline.service.application.strategies.PaymentDebitoStrategy;
import com.pipeline.service.application.strategies.PaymentPixStrategy;
import com.pipeline.service.application.strategies.PaymentStrategy;
import com.pipeline.service.application.workflow.context.CreateDadosPagamentoContext;
import com.pipeline.service.application.workflow.exceptions.PipelineFiltersException;
import com.pipeline.service.domain.PaymentType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateDadosPagamentoPaymentFilter implements Filter<CreateDadosPagamentoContext> {

    @Override
    public void apply(CreateDadosPagamentoContext ctx) {

        PaymentStrategy paymentStrategy = privateSimplePaymentFactory(ctx.getRequest().paymentType());
        paymentStrategy.execute(ctx.getRequest().total());
        ctx.setPayedAt(LocalDateTime.now());

    }

    private PaymentStrategy privateSimplePaymentFactory(PaymentType paymentType) {
        switch(paymentType) {
            case CREDIARIO -> {
                return new PaymentCreditoStrategy();
            }
            case DEBITO -> {
                return new PaymentDebitoStrategy();
            }
            case PIX -> {
                return new PaymentPixStrategy();
            }
            case null, default -> throw new PipelineFiltersException("Payment type not allowed.");
        }

    }
}
