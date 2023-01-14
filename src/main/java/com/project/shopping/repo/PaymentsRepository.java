package com.project.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopping.model.Payments;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Integer> {

}
