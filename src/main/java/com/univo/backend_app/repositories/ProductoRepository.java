package com.univo.backend_app.repositories;

import com.univo.backend_app.models.ProductoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoDTO, Long> {
    // Administra los ProductoDTO directamente contra la base de datos
}