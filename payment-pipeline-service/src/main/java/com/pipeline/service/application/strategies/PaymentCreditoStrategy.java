package com.pipeline.service.application.strategies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class PaymentCreditoStrategy implements PaymentStrategy {

    @Override
    public void execute(BigDecimal value) {
        log.info("::: Mock payment using credit...");
        log.info("::: payment sucessfully, value: {}", value);
    }
}
