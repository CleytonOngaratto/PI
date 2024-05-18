package com.materialescolar.pi.repository;

import com.materialescolar.pi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserModel, Long> {

//    Optional<UserModel> findByLoginAndPassword(String username, String password);


    @Query(value = "select * from usuarios where username = :username and password = :password", nativeQuery = true)
    public UserModel login(String username, String password);

}
