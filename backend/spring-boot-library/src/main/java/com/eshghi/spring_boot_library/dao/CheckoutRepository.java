package com.eshghi.spring_boot_library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshghi.spring_boot_library.entity.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long>{
    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);
    List<Checkout> findBooksByUserEmail(String userEmail);
}
