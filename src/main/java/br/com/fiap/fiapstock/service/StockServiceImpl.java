package br.com.fiap.fiapstock.service;

import br.com.fiap.fiapstock.dto.StockCreateUpdateDTO;
import br.com.fiap.fiapstock.dto.StockDTO;
import br.com.fiap.fiapstock.model.Stock;
import br.com.fiap.fiapstock.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    private StockPriceCheck stockPriceCheck;
    private StockRepository stockRepository;

    public StockServiceImpl(
            StockPriceCheck stockPriceCheck,
            StockRepository stockRepository
    ) {
        this.stockPriceCheck = stockPriceCheck;
        this.stockRepository = stockRepository;
    }

    @Override
    public List<StockDTO> findAll(String search) {
        String searchTerm = search == null ? "" : search;
//        return stockRepository.findAllByNomeContainingAndAtivoIsTrue(searchTerm)
        return stockRepository.buscaPorNome(searchTerm)
                .stream()
                .map(StockDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public StockDTO findById(Long id) {
        return null;
    }

    @Override
    public StockDTO create(StockCreateUpdateDTO stockCreateUpdateDTO) {
        Stock stock = new Stock(stockCreateUpdateDTO);

        Stock savedStock = stockRepository.save(stock);

        return new StockDTO(savedStock);
    }

    @Override
    public StockDTO update(StockCreateUpdateDTO stockCreateUpdateDTO, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
