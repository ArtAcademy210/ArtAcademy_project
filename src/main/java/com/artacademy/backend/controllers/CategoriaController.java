package com.artacademy.backend.controllers;

import com.artacademy.backend.models.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class CategoriaController {
    @Autowired 
    private CategoriaService Categoria;
    @GetMapping ("/Categorias")
    public String ListaCategorias(Model model){
        model.addAttribute("Lista", Categoria.ListaCategoria());
        return "Categorias/ListarCategorias";
    }
    
}
