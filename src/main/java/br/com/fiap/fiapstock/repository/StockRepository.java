package br.com.fiap.fiapstock.repository;

import br.com.fiap.fiapstock.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findAllByNomeContainingAndAtivoIsTrue(String nome);

    @Query("from Stock s " +
            "where s.nome like %:nome% " +
            "and s.ativo = true")
    List<Stock> buscaPorNome(String nome);

}
