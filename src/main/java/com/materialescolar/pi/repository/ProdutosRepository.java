package com.materialescolar.pi.repository;

import com.materialescolar.pi.model.ProdutosModel;
import com.materialescolar.pi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {



}
