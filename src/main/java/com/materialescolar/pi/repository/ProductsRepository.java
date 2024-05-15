package com.materialescolar.pi.repository;

import com.materialescolar.pi.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductsRepository extends JpaRepository<ProductModel, Long> {



}
