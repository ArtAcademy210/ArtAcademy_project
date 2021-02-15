package com.artacademy.backend.controllers;

import com.artacademy.backend.models.entity.Obra;
import com.artacademy.backend.models.entity.ObraCaracteristica;
import com.artacademy.backend.models.service.CaracteristicaService;
import com.artacademy.backend.models.service.ObraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CaracteristicasController {
    @Autowired
    private CaracteristicaService caraser;
    @Autowired
    private ObraService obraser;
    @PostMapping("/agregar/caracteristica")
    public String agregarCaracteristica(ObraCaracteristica obraCaracteristica){
        caraser.guardarCaracteristica(obraCaracteristica);
        return "redirect:/obras";
    }
    @GetMapping("/atributos/obra/{id}")
    public String atributos(@PathVariable(value = "id") Long id, Model model){
        Obra obra = obraser.buscarObra(id);
        if(obra==null){
            return "redirect:/obras";
        }
        ObraCaracteristica obracara = new ObraCaracteristica();
        obracara.setObra(obra);
     
        model.addAttribute("caracteristica", obracara);
        model.addAttribute("caracteristicas", caraser.listarObrasCaracteristicas());
    
        return "obra/atributos";
    }
    
}
