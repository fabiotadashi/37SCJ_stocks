package br.com.fiap.fiapstock.controller;

import br.com.fiap.fiapstock.dto.StockCreateUpdateDTO;
import br.com.fiap.fiapstock.dto.StockDTO;
import br.com.fiap.fiapstock.service.StockService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    @Operation(description = "Listagem de ações por nome")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "ok"),
                    @ApiResponse(responseCode = "404", description = "stocks.not.found")
            }
    )
    public List<StockDTO> findAll(
            @RequestParam(required = false, value = "nome") String nome
    ) {
        return stockService.findAll(nome);
    }

    @GetMapping("{id}")
    public StockDTO getById(
            @PathVariable Long id
    ) {
        return stockService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockDTO create(
            @RequestBody StockCreateUpdateDTO stockCreateUpdateDTO
    ) {
        return stockService.create(stockCreateUpdateDTO);
    }

    @PutMapping("{id}")
    public StockDTO update(
            @RequestBody StockCreateUpdateDTO stockCreateUpdateDTO,
            @PathVariable Long id
    ) {
        return stockService.update(stockCreateUpdateDTO, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long id
    ) {
        stockService.delete(id);
    }

}
