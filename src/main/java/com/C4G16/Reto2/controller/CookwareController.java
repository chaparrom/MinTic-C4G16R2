/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.C4G16.Reto2.controller;

import com.C4G16.Reto2.model.Cookware;
import com.C4G16.Reto2.service.CookwareService;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/cookware")
@CrossOrigin("*")
public class CookwareController {
/**
 * Definición del Servicio
 */
    @Autowired
    private CookwareService cookwareService;
/**
 * Proceso para traer todos los productos de la BD
 * @return Una lista de productos existentes
 */
    @GetMapping("/all")
    public List<Cookware> getAll() {
        return cookwareService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional <Cookware> getCookware(@PathVariable("id") String reference) {
        return cookwareService.getCookware(reference);
    }  
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)    
    public Cookware save(@RequestBody Cookware cookware) {
        return cookwareService.save(cookware);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)    
    public Cookware update(@RequestBody Cookware cookware) {
        return cookwareService.update(cookware);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") String reference) {
        return cookwareService.delete(reference);
    }  
}
