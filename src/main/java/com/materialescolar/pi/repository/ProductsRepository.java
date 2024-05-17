package com.materialescolar.pi.repository;

import com.materialescolar.pi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductsRepository extends JpaRepository<Product, Long> {



}
