package com.materialescolar.pi.controller;

import com.materialescolar.pi.model.ProdutosModel;
import com.materialescolar.pi.repository.ProdutosRepository;
import com.materialescolar.pi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {


        @Autowired
        private UserService userService;

        @Autowired
        private ProdutosRepository produtosRepository;



        @PostMapping("/addProduto")
        public ResponseEntity<ProdutosModel> addBook(@RequestBody ProdutosModel produto) {
            try {
                ProdutosModel produtoObj = produtosRepository.save(produto);
                return new ResponseEntity<>(produtoObj, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }




    }

}
