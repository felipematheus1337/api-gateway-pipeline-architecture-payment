package com.pipeline.service.domain.request;

import com.pipeline.service.domain.PaymentType;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;
import java.math.BigDecimal;

@Builder
public record CreateDadosPagamentoRequest(PaymentType paymentType, @Min(1) BigDecimal total, @CPF String cpf) {
}
