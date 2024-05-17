//package com.materialescolar.pi.service;
//
//import com.materialescolar.pi.model.UserModel;
//import com.materialescolar.pi.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    public UserModel registerUser(String login, String password, String email) {
//        if(login == null || password == null) {
//            return null;
//        } else{
//            UserModel userModel = new UserModel();
//            userModel.setLogin(login);
//            userModel.setPassword(password);
//            userModel.setEmail(email);
//            System.out.print(userModel);
//            return userRepository.save(userModel);
//        }
//    }
//
//    public UserModel authenticate(String login, String password) {
//        return userRepository.findByLoginAndPassword(login, password).orElseThrow(null);
//    }
//
//    public List<UserModel> findAll() {
//        return userRepository.findAll();
//    }
//
//}
