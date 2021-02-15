package com.artacademy.backend.controllers;

import com.artacademy.backend.models.entity.Obra;

import com.artacademy.backend.models.service.FileService;
import com.artacademy.backend.models.service.ObraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;


@Controller
@SessionAttributes("obras")
public class ObraController {
@Autowired
private ObraService obraser;
@Autowired
private FileService fileser;
@GetMapping("/obras")
public String listar(Model model){
    model.addAttribute("obras", obraser.listarObras());
    return "obra/listar";
}
@GetMapping("/obras/formulario")
public String crear(Model model){
    model.addAttribute("obra", new Obra());
    return "obra/formulario";
}
@PostMapping("/obra/guardar")
public String guardar(Obra obra, Model model, @RequestParam("file") MultipartFile foto,  SessionStatus status){

    if(!foto.isEmpty()){
        if(obra.getId() !=null && obra.getId() > 0 && obra.getImagen() != null
        && obra.getImagen().length()>0){
            fileser.eliminar(obra.getImagen());
        }
        String uniconombre = null;
        try {
            uniconombre = fileser.copiar(foto);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        obra.setImagen(uniconombre);
        obra.setEstado(true);
    }
    obraser.guardarObra(obra);
    status.setComplete();
    return "redirect:/obras";
}


}
