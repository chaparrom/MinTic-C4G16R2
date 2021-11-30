/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.C4G16.Reto2.service;

import com.C4G16.Reto2.model.User;
import com.C4G16.Reto2.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edgarchaparro
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll() {
        return userRepository.getAll();
    }

//    public Optional<User> getUser(int id) {
//        return userRepository.getUser(id);
//    }

    public User save(User user) {

        if (userRepository.emailExists(user.getEmail()) == false) {
            if (user.getId() == null) {
                user.setId(userRepository.nextNumber().get().getId() + 1); 
            }
            return userRepository.save(user);
        } 
        else {
                return user;
            }
    }

    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    public User userLogin(String email, String password) {

        Optional<User> usuario = userRepository.login(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    
    public User update(User user){
        
        Optional<User> temporal = userRepository.getUser(user.getEmail());
        
        if(!temporal.isEmpty()){
            if(user.getIdentification() != null)
                temporal.get().setIdentification(user.getIdentification());
            if(user.getName() != null)
                temporal.get().setName(user.getName());
            if(user.getAddress() != null)
                temporal.get().setAddress(user.getAddress());
            if(user.getCellPhone() != null)
                temporal.get().setCellPhone(user.getCellPhone());
            if(user.getEmail() != null)
                temporal.get().setEmail(user.getEmail());
            if(user.getPassword() != null)
                temporal.get().setPassword(user.getPassword());
            if(user.getZone() != null)
                temporal.get().setZone(user.getZone());
            if(user.getType() != null)
                temporal.get().setType(user.getType());
            
            return userRepository.save(temporal.get());
        }
        else
            return user;
    }

    public boolean delete(Integer id) {
        Optional<User> temporal = userRepository.getUserId(id);

        if(!temporal.isEmpty()){
            userRepository.delete(temporal.get());
            return true;
        }
        else
            return false;
    }
    
    

}
