package com.pipeline.service.infra.presentation;

import com.pipeline.service.application.CreateDadosPagamentoUseCase;
import com.pipeline.service.domain.request.CreateDadosPagamentoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/dados-pagamento")
@RequiredArgsConstructor
public class DadosPagamentoController {

    private final CreateDadosPagamentoUseCase createDadosPagamentoUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Void> create(@RequestBody CreateDadosPagamentoRequest request) {
        createDadosPagamentoUseCase.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
