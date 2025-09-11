package com.salahhaddara.miniecommercespringboot.repository;

import com.salahhaddara.miniecommercespringboot.entity.Order;
import com.salahhaddara.miniecommercespringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserOrderByCreatedAtDesc(User user);
}
