package com.univo.backend_app.models;

public class ProductoDTO {
    private String nombre;
    private int stockActual;
    private int stockMinimo;
    private String categoria;

    // Constructor vacío (Obligatorio para que Spring Boot deserialice el JSON)
    public ProductoDTO() {}

    // Constructor con parámetros
    public ProductoDTO(String nombre, int stockActual, int stockMinimo, String categoria) {
        this.nombre = nombre;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.categoria = categoria;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getStockActual() { return stockActual; }
    public void setStockActual(int stockActual) { this.stockActual = stockActual; }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}