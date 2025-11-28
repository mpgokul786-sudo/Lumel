package com.example.customer.controller;


import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class CustomerCall {
    @Autowired
    private CustomerService dataLoaderService;

    @PostMapping("/refresh-data")
    public ResponseEntity<String> triggerDataRefresh(@RequestParam String filePath) {
        try {
            dataLoaderService.loadSalesDataFromCsv(filePath);
            return ResponseEntity.ok("Data refresh triggered and completed. Check logs for details.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Data refresh failed: " + e.getMessage());
        }
    }
}
