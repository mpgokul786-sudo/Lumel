package com.example.customer.controller;

import com.example.customer.service.SalesAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {
    @Autowired
    private SalesAnalysisService salesAnalysisService;

    // Example Usage: GET /api/analysis/revenue-by-product?startDate=2023-01-01&endDate=2023-12-31
    @GetMapping("/revenue-by-product")
    public ResponseEntity<Map<String, BigDecimal>> getRevenueByProduct(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        Map<String, BigDecimal> revenueData = salesAnalysisService.getTotalRevenueByProduct(startDate, endDate);
        return ResponseEntity.ok(revenueData);
    }
}
