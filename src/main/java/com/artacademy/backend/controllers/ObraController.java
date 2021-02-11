package com.artacademy.backend.controllers;

import com.artacademy.backend.models.service.ObraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ObraController {
@Autowired
private ObraService obraser;
@GetMapping("/obras")
public String listar(Model model){
    model.addAttribute("obras", obraser.listarObras());
    return "obra/listar";
}
@GetMapping("/obras/formulario")
public String crear(Model model){
    return "obra/formulario";
}
}
