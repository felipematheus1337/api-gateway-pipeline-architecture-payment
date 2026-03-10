package com.pipeline.service.application.workflow.context;


import com.pipeline.service.domain.DadosPagamentoCollection;
import com.pipeline.service.domain.request.CreateDadosPagamentoRequest;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
public class CreateDadosPagamentoContext implements DadosPagamentoContext {

    private CreateDadosPagamentoRequest request;
    private DadosPagamentoCollection collection;
    private LocalDateTime payedAt;

    public CreateDadosPagamentoContext(CreateDadosPagamentoRequest request) {
        this.request = request;
    }

    public void transformToCollection() {
        collection.setCpf(request.cpf());
        collection.setTotal(request.total());
        collection.setPayedAt(getPayedAt());
        collection.setPaymentType(request.paymentType());
    }

    public void setPayedAt(LocalDateTime payedAt) {
        this.payedAt = payedAt;
    }
}
