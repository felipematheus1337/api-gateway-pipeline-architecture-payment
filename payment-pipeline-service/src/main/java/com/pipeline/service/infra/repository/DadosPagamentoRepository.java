package com.pipeline.service.infra.repository;

import com.pipeline.service.domain.DadosPagamentoCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosPagamentoRepository extends MongoRepository<DadosPagamentoCollection, String> {
}
