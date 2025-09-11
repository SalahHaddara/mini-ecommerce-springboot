package com.salahhaddara.miniecommercespringboot.repository;

import com.salahhaddara.miniecommercespringboot.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}