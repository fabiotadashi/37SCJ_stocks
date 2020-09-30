package br.com.fiap.fiapstock;

import br.com.fiap.fiapstock.dto.StockDTO;
import br.com.fiap.fiapstock.model.Stock;
import br.com.fiap.fiapstock.repository.StockRepository;
import br.com.fiap.fiapstock.service.StockPriceCheckImpl;
import br.com.fiap.fiapstock.service.StockService;
import br.com.fiap.fiapstock.service.StockServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class FiapstockUnitTests {

    @Test
    public void findAllStocks(){
        // Preparação
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        List<Stock> stockList = new ArrayList<>();

        Stock stock = new Stock();
        stock.setNome("MGLU3");
        stock.setDescricao("Magazine Luiza");
        stockList.add(stock);

        Mockito.when(stockRepository.buscaPorNome("MGLU3")).thenReturn(stockList);

        // Execução
        StockService stockService = new StockServiceImpl(new StockPriceCheckImpl(), stockRepository);
        List<StockDTO> stockDTOList = stockService.findAll("MGLU3");

        // Verificação
        Assertions.assertEquals(1, stockDTOList.size());
        Assertions.assertEquals("MGLU3", stockDTOList.get(0).getNome());
        Assertions.assertEquals("Magazine Luiza", stockDTOList.get(0).getDescricao());
    }


}
