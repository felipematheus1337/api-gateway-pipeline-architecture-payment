package com.pipeline.service.application.workflow.filters;

import com.pipeline.service.application.workflow.context.CreateDadosPagamentoContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

@Component
@Slf4j
public class CreateDadosPagamentoNotificationFilter implements Filter<CreateDadosPagamentoContext> {

    @Override
    public void apply(CreateDadosPagamentoContext ctx) {
        log.info("::: Mock sending notifications");
        int randomInt = new Random().nextInt();
        BigDecimal value = ctx.getRequest().total();

        if (randomInt <= 10) {
            log.info("::: Mock sending to SNS value");
            mockMessage(value);
        } else {
            log.info("::: Mock sending to e-mail value");
            mockMessage(value);
        }
    }

    private static String mockMessage(BigDecimal value) {
        return String.format(
                "Payment sucessfully approved"
                + "value: %f"
        , value);
    }
}
