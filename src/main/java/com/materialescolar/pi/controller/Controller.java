//package com.materialescolar.pi.controller;
//
//import com.materialescolar.pi.model.Usuario;
//import com.materialescolar.pi.repository.Repository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//public class Controller {
//
//    @Autowired
//    private Repository repository;
//
//    @PostMapping("/add")
//    public String addUsuario(@RequestParam String nome, @RequestParam String email) {
//        Usuario usuario = new Usuario();
//        usuario.setNome("first");
//        usuario.setEmail("last");
//        repository.save(usuario);
//        return "Added new customer to repo!";
//    }
//
//    @GetMapping("/list")
//    public Iterable<Usuario> getUsuarios() {
//        return repository.findAll();
//    }
//
//    @GetMapping("/find/{id}")
//    public Optional<Usuario> findUsuarioById(@PathVariable Integer id) {
//        return repository.findById(id);
//    }
//}