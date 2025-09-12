package com.salahhaddara.miniecommercespringboot.repository;

import com.salahhaddara.miniecommercespringboot.entity.Order;
import com.salahhaddara.miniecommercespringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserOrderByCreatedAtDesc(User user);

    @Query("SELECT o FROM Order o ORDER BY o.createdAt DESC")
    List<Order> findAllOrdersOrderByCreatedAtDesc();

    @Query("SELECT o FROM Order o WHERE o.user = :user ORDER BY o.createdAt DESC")
    List<Order> findUserOrdersOrderByCreatedAtDesc(@Param("user") User user);
}
