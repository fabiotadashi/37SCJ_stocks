package br.com.fiap.scjWebflux.service

import br.com.fiap.scjWebflux.dto.CreatePessoaDTO
import br.com.fiap.scjWebflux.dto.PessoaDTO
import br.com.fiap.scjWebflux.model.PessoaDocument
import br.com.fiap.scjWebflux.repository.PessoaRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

@Service
class PessoaServiceImpl(
        private val pessoaRepository: PessoaRepository
) : PessoaService {

    override fun create(createPessoaDTO: CreatePessoaDTO) = Mono.just( createPessoaDTO )
            .map {
                PessoaDocument(nome = createPessoaDTO.nome ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST))
            }
            .flatMap { pessoaRepository.save(it) }
            .map { PessoaDTO(id = it.id ?: "", nome = it.nome) }

    override fun getAll() = pessoaRepository.findAll()
            .map { PessoaDTO(id = it.id ?: "", nome = it.nome) }

}