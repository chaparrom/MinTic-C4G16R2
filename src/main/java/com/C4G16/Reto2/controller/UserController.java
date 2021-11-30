/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.C4G16.Reto2.controller;

import com.C4G16.Reto2.model.User;
import com.C4G16.Reto2.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edgarchaparro
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
/**
 * Definición del Servicio
 */
    @Autowired
    private UserService userService;
/**
 * Proceso para traer todos los usuarios de la BD
 * @return Una lista de usuarios existentes
 */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
/**
 * Proceso para creación de usuarios en la BD
 * @param user cuenta de correo del nuevo usuario
 * @return la instancia del usuario creado
 */    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
/**
 * Proceso para validar la existencia del usuario con su cuenta de correo y su password
 * @param email 
 * @param password
 * @return la instancia del usuario o una instancia con nombre NO DEFINIDO
 */    
    @GetMapping("/{email}/{password}")
    public User userLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.userLogin(email, password);
    }
/**
 * Proceso para validar la existencia del usuario solamente con la cuenta de correo
 * @param email
 * @return true para indicar que la cuenta de correo ya está registrada y false en caso que no exista registro
 */    
    @GetMapping("emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }   
/**
 * Proceso para actualizar la información del usuario
 * @param user Objeto con la información nueva del usuario
 * @return El objeto User actualizado o la información original enviada en el caso que no haya sido satisfactoria
 */    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
/**
 * Proceso para eliminar el usuario de la base de datos
 * @param id Identificador del usuario que se requiere eliminar de la base de datos
 * @return Retorna True en el caso que se elimine el usuario, False en el caso que no se pueda eliminar.
 */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return userService.delete(id);
    }
}
    