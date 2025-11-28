package com.example.customer.service;


import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    // Inject Repositories for Product, Order, Region, Customer, OrderItem

    @Transactional
    public void loadSalesDataFromCsv(String filePath) {
        logger.info("Starting data refresh process from file: {}", filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            //
            reader.readLine();
            while ((line = reader.readLine()) != null) {
// we need to implemnt in Repository
            }
            logger.info("Data refresh completed successfully.");
        } catch (IOException e) {
            logger.error("Data refresh failed: Error reading CSV file", e);
            throw new RuntimeException("Failed to load data", e);
        }
    }
}
