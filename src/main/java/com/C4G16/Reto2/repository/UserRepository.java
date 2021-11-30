/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.C4G16.Reto2.repository;

import com.C4G16.Reto2.interfaces.UserInterface;
import com.C4G16.Reto2.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author edgarchaparro
 */
@Repository
public class UserRepository {
    @Autowired
    private UserInterface crud;
    
    public List<User> getAll(){
        return (List<User>) crud.findAll();
    }
    
    public Optional <User> getUserId(Integer id){
        return crud.findById(id);
    }
    
    public User save(User user){
        return crud.save(user);
    }
    
    public boolean emailExists(String email) {
        Optional<User> user = crud.findByEmail(email);
        return !user.isEmpty();
    }
    
    public Optional<User> getUser(String email) {
        return crud.findByEmail(email);
    }
    
    public Optional<User> login(String email, String password) {
        return crud.findByEmailAndPassword(email, password);
    }
        
    public void delete(User user){
        crud.delete(user);
    }
    
    public Optional<User> nextNumber() {
        return crud.findTopByOrderByIdDesc();
    }
    
}
