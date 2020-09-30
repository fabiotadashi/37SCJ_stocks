package br.com.fiap.scjWebflux.repository

import br.com.fiap.scjWebflux.model.PessoaDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PessoaRepository: ReactiveMongoRepository<PessoaDocument, String>