package com.app.hotel.productos.repository;

import com.app.hotel.productos.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Integer>  {

}
