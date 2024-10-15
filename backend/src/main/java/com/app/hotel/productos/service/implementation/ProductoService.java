package com.app.hotel.productos.service.implementation;

import com.app.hotel.productos.model.dto.ProductoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService {

    List<ProductoDto> listarTodos();  // Listar todos los productos

    Page<ProductoDto> paginar(Pageable pageable);  // Listar productos paginados

    ProductoDto obtenerPorId(Integer id);  // Obtener un producto por su ID

    ProductoDto guardarProducto(ProductoDto productoDto);  // Guardar un nuevo producto o actualizar uno existente

    ProductoDto actualizarProducto(Integer id, ProductoDto productoDto);  // Actualizar un producto existente

    void eliminarProducto(Integer id);  // Eliminar un producto por su ID
}