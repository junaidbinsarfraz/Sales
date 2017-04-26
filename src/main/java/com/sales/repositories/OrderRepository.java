package com.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
