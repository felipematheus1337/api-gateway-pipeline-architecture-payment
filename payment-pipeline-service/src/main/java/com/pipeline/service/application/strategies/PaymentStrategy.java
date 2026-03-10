package com.pipeline.service.application.strategies;

import java.math.BigDecimal;

public interface PaymentStrategy {

    void execute(BigDecimal value);
}
