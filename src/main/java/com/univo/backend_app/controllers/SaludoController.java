package com.univo.backend_app.controllers;

import com.univo.backend_app.models.MensajeDTO;
import com.univo.backend_app.repositories.MensajeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mensajes") // Esta es la URL base para este controlador
@CrossOrigin(origins = "http://localhost:4200")
public class SaludoController {
    private final MensajeRepository repository;

    // Inyección de dependencia por constructor
    public SaludoController(MensajeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MensajeDTO> listaMensajes() {
        return repository.findAll();    // Hace un SELECT * FROM mensajes
    }

    @PostMapping
    public MensajeDTO guardarMensaje(@RequestBody MensajeDTO nuevoMensaje) {
        return repository.save(nuevoMensaje);   // Hace un INSERT INTO mensajes
    }
}
