package com.pjjstock.stock.controller;

import com.pjjstock.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/stock")
public class StockController {
    private final StockService stockService;

    @PutMapping
    public void updateStock(@RequestParam("stockId") Long stockId,
                            @RequestParam("memberId") Long memberId,
                            @RequestParam("num") int num) {
        stockService.clicked(stockId, memberId, num);
    }

}
