package com.univo.backend_app.controllers;

import com.univo.backend_app.models.ProductoDTO;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productos") // URL Base del SaaS O.S.A.
public class InventarioController {

    // 1. Endpoint GET: Devuelve la lista simulada de productos en stock
    @GetMapping
    public List<ProductoDTO> obtenerInventario() {
        List<ProductoDTO> inventarioSimulado = new ArrayList<>();

        // Agregamos algunos productos iniciales para las pruebas
        inventarioSimulado.add(new ProductoDTO("Cable UTP Categoría 6", 8, 20, "Redes"));
        inventarioSimulado.add(new ProductoDTO("Conector RJ45 blindado", 150, 50, "Conectores"));
        inventarioSimulado.add(new ProductoDTO("Switch de 24 puertos Gigabit", 3, 5, "Equipos de Red"));

        return inventarioSimulado;
    }

    // 2. Endpoint POST: Recibe un nuevo producto de Angular y simula su guardado
    @PostMapping("/registrar")
    public String registrarNuevoProducto(@RequestBody ProductoDTO nuevoProducto) {
        // En un futuro aquí usaremos un repositorio JPA para guardar en la base de datos MySQL
        System.out.println("Producto recibido con éxito en el Servidor: " + nuevoProducto.getNombre());

        return "¡Éxito! El producto '" + nuevoProducto.getNombre() + "' de la categoría '"
                + nuevoProducto.getCategoria() + "' ha sido registrado en el inventario de O.S.A.";
    }
}