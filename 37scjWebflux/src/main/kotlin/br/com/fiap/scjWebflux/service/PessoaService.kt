package br.com.fiap.scjWebflux.service

import br.com.fiap.scjWebflux.dto.CreatePessoaDTO
import br.com.fiap.scjWebflux.dto.PessoaDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PessoaService {

    fun create(createPessoaDTO: CreatePessoaDTO): Mono<PessoaDTO>

    fun getAll(): Flux<PessoaDTO>

}