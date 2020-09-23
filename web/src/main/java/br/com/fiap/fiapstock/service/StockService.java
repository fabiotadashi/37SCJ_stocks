package br.com.fiap.fiapstock.service;

import br.com.fiap.fiapstock.dto.StockCreateUpdateDTO;
import br.com.fiap.fiapstock.dto.StockDTO;

import java.util.List;

public interface StockService {

    List<StockDTO> findAll(String search);
    StockDTO findById(Long id);
    StockDTO create(StockCreateUpdateDTO stockCreateUpdateDTO);
    StockDTO update(StockCreateUpdateDTO stockCreateUpdateDTO, Long id);
    void delete(Long id);

}
