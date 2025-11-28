package com.example.customer.service;

import com.example.customer.repository.Repositaory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SalesAnalysisService {
    @Autowired
    private Repositaory orderItemRepository;

    public Map<String, BigDecimal> getTotalRevenueByProduct(LocalDate startDate, LocalDate endDate) {
        List<Object[]> results = orderItemRepository.findTotalRevenueByProductForDateRange(startDate, endDate);

        Map<String, BigDecimal> revenueMap = new HashMap<>();
        for (Object[] result : results) {
            String productName = (String) result[0];
            BigDecimal totalRevenue = (BigDecimal) result[1];
            revenueMap.put(productName, totalRevenue);
        }
        return revenueMap;
    }
}
