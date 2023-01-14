package com.project.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopping.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
