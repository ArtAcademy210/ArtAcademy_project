package com.artacademy.backend.controllers;

import java.net.MalformedURLException;


import com.artacademy.backend.models.entity.Obra;
import com.artacademy.backend.models.entity.ObraImagenes;
import com.artacademy.backend.models.service.FileService;
import com.artacademy.backend.models.service.ObraImagenesService;
import com.artacademy.backend.models.service.ObraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

@Controller
@SessionAttributes("obraimagen")
public class ImagenesController {
    @Autowired
    private ObraService obraser;
    @Autowired
    private ObraImagenesService obraserimg;
    @Autowired
    private FileService fileser;


    
    @GetMapping("/galeria/obra/{id}")
    public String imagenes(@PathVariable(value = "id") Long id, Model model){
        Obra obra = obraser.buscarObra(id);
        if(obra==null){
            return "redirect:/obras";
        }
        ObraImagenes obraimg = new ObraImagenes();
        obraimg.setObra(obra);
        model.addAttribute("obraimagen", obraimg);
        model.addAttribute("obrasimagenes", obraserimg.listarObraImagenes());
        return "obra/imagenes";

    }

    @PostMapping("/obra/imagenes")
public String guardar(ObraImagenes obraimg, Model model, @RequestParam("file") MultipartFile foto,  SessionStatus status){

    if(!foto.isEmpty()){
        if(obraimg.getId() !=null && obraimg.getId() > 0 && obraimg.getUrlimagen() != null
        && obraimg.getUrlimagen().length()>0){
            fileser.eliminar(obraimg.getUrlimagen());
        }
        String uniconombre = null;
        try {
            uniconombre = fileser.copiar(foto);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        obraimg.setUrlimagen(uniconombre);
        
    }
    obraserimg.guardarImagenes(obraimg);
    status.setComplete();
    return "redirect:/galeria/obra/"+obraimg.getObra().getId();
}
@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;

		try {
			recurso = fileser.cargar(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}
    
    @GetMapping("/eliminar/galeria/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        ObraImagenes obraimg=null;
       if(id > 0){
        obraimg = obraserimg.buscarObraImagenes(id);
           obraserimg.eliminarImagenes(id);
           if(fileser.eliminar(obraimg.getUrlimagen())){

           }
       } 
       return "redirect:/galeria/obra/"+obraimg.getObra().getId();
    }
}
