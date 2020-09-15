package br.com.fiap.fiapstock.repository;

import br.com.fiap.fiapstock.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findAllByNomeContainingAndAtivoIsTrue(String nome);

    @Query("from Stock s " +
            "where s.nome like %:nome% " +
            "and s.ativo = true")
    List<Stock> buscaPorNome(String nome);

    Optional<Stock> findByIdAndAtivoIsTrue(Long id);

}
