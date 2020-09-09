package br.com.fiap.fiapstock.service;

import br.com.fiap.fiapstock.dto.StockCreateUpdateDTO;
import br.com.fiap.fiapstock.dto.StockDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    private List<StockDTO> stockDTOList = new ArrayList<>();

    private StockPriceCheck stockPriceCheck;

    public StockServiceImpl(StockPriceCheck stockPriceCheck){
        this.stockPriceCheck = stockPriceCheck;
    }

    @Override
    public List<StockDTO> findAll(String search) {
        return stockDTOList
                .stream()
                .filter(stockDTO -> search == null || stockDTO.getNome().contains(search.toUpperCase()))
                .filter(StockDTO::getAtivo)
                .collect(Collectors.toList());
    }

    @Override
    public StockDTO findById(Long id) {
        return null;
    }

    @Override
    public StockDTO create(StockCreateUpdateDTO stockCreateUpdateDTO) {
        return null;
    }

    @Override
    public StockDTO update(StockCreateUpdateDTO stockCreateUpdateDTO, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
