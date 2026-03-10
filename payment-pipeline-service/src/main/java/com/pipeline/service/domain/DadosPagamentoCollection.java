package com.pipeline.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dados_pagamento")
public class DadosPagamentoCollection {

    @Id
    private String id;

    private PaymentType paymentType;

    private BigDecimal total;

    private LocalDateTime payedAt;

    @CPF
    private String cpf;
}

