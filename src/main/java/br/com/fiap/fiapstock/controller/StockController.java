package br.com.fiap.fiapstock.controller;

import br.com.fiap.fiapstock.dto.StockCreateUpdateDTO;
import br.com.fiap.fiapstock.dto.StockDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("stocks")
public class StockController {

    private List<StockDTO> stockDTOList = new ArrayList<>();

    @GetMapping
    public List<StockDTO> findAll(
            @RequestParam(required = false, value = "nome") String nome
    ) {
        return stockDTOList
                .stream()
                .filter(stockDTO -> nome == null || stockDTO.getNome().contains(nome.toUpperCase()))
                .filter(StockDTO::getAtivo)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public StockDTO getById(
            @PathVariable Long id
    ){
        return stockDTOList
                .stream()
                .filter(stockDTO -> stockDTO.getId().equals(id) && stockDTO.getAtivo())
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockDTO create(
            @RequestBody StockCreateUpdateDTO stockCreateUpdateDTO
    ) {

        StockDTO stockDTO = new StockDTO();
        stockDTO.setId(stockDTOList.size() + 1L);
        stockDTO.setNome(stockCreateUpdateDTO.getNome());
        stockDTO.setDescricao(stockCreateUpdateDTO.getDescricao());
        stockDTO.setValor(stockCreateUpdateDTO.getValor());
        stockDTO.setAtivo(true);

        stockDTOList.add(stockDTO);
        return stockDTO;
    }

    @PutMapping("{id}")
    public StockDTO update(
            @RequestBody StockCreateUpdateDTO stockCreateUpdateDTO,
            @PathVariable Long id
    ) {
        StockDTO stockDTO = getById(id);
        stockDTO.setNome(stockCreateUpdateDTO.getNome());
        stockDTO.setDescricao(stockCreateUpdateDTO.getDescricao());
        stockDTO.setValor(stockCreateUpdateDTO.getValor());
        return stockDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long id
    ) {
        StockDTO stockDTO = getById(id);
        stockDTO.setAtivo(false);
    }

    // Mock list
    public StockController() {
        StockDTO stockDTO1 = new StockDTO();
        stockDTO1.setId(1L);
        stockDTO1.setNome("MGLU3");
        stockDTO1.setDescricao("Magazine Luiza 3");
        stockDTO1.setAtivo(true);
        stockDTO1.setValor(BigDecimal.valueOf(20.4));

        StockDTO stockDTO2 = new StockDTO();
        stockDTO2.setId(2L);
        stockDTO2.setNome("ITSA3");
        stockDTO2.setDescricao("Itausa");
        stockDTO2.setAtivo(true);
        stockDTO2.setValor(BigDecimal.valueOf(19.2));

        stockDTOList.add(stockDTO1);
        stockDTOList.add(stockDTO2);

    }
}
