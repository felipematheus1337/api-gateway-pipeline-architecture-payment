package com.pipeline.service.infra.presentation;

import com.pipeline.service.application.CreateDadosPagamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/dados-pagamento")
@RequiredArgsConstructor
public class DadosPagamentoController {

    private final CreateDadosPagamentoUseCase createDadosPagamentoUseCase;

    @PostMapping
    ResponseEntity<Void> create(@RequestBody CreateDadosPagamentoRequest request) {

    }
}
