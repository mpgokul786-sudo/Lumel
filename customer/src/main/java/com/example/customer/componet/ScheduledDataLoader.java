package com.example.customer.componet;

import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduledDataLoader {
    @Autowired
    private CustomerService dataLoaderService;

    public void dailyDataRefresh() {
        // Escaped backslashes are necessary in a Java string literal for Windows paths
        dataLoaderService.loadSalesDataFromCsv("C:\\Users\\gokul\\Downloads\\daily_sales.csv");
    }

}
