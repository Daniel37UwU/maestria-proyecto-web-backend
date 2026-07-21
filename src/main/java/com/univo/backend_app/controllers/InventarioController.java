package com.univo.backend_app.controllers;

import com.univo.backend_app.models.ProductoDTO;
import com.univo.backend_app.repositories.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class InventarioController {

    private final ProductoRepository repository;

    public InventarioController(ProductoRepository repository) {
        this.repository = repository;
    }

    // 1. GET: Retorna la lista de DTOs directo desde Neon
    @GetMapping
    public List<ProductoDTO> obtenerInventario() {
        return repository.findAll();
    }

    // 2. POST: Recibe y guarda el DTO directamente
    @PostMapping
    public ProductoDTO registrarNuevoProducto(@RequestBody ProductoDTO nuevoProducto) {
        return repository.save(nuevoProducto);
    }
}