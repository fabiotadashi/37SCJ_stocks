package br.com.fiap.fiapstock.service;

import br.com.fiap.fiapstock.dto.StockDTO;

public interface StockPriceCheck {

    boolean checkPrice(StockDTO stockDTO);

}
