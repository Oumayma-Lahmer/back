package com.fss.pharmacie.controller;


import com.fss.pharmacie.models.Stock;
import com.fss.pharmacie.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    private final StockService stockService;
    public StockController (StockService stockService){
        this.stockService= stockService;
    }
    @GetMapping("/list")
    public List<Stock> getAllStock() {
        return stockService.getAllStock();
    }
    @PostMapping("/save")
    public Stock saveStock(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}
