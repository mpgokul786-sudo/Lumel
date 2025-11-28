package com.example.customer.repository;

import com.example.customer.model.Customer;
import com.example.customer.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Repositaory extends JpaRepository<OrderItem, Long> {

    // JPQL Query to sum quantity * unit_price grouped by product name within a date range
    @Query(
            "SELECT oi.product.name, SUM(oi.quantity * oi.priceAtPurchase) \n" +
            "FROM OrderItem oi \n" +
            "WHERE oi.order.orderDate BETWEEN :startDate AND :endDate \n" +
            "GROUP BY oi.product.name\n")
    List<Object[]> findTotalRevenueByProductForDateRange(@Param("startDate") LocalDate startDate,
                                                         @Param("endDate") LocalDate endDate);
}

