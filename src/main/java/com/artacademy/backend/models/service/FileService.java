package com.artacademy.backend.models.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public Resource cargar(String nombre) throws MalformedURLException;
    public String copiar(MultipartFile file) throws IOException;
    public boolean eliminar(String nombre);
}
