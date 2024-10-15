package com.app.hotel.productos.controller;

import com.app.hotel.productos.model.dto.ProductoDto;
import com.app.hotel.productos.model.entity.Producto;
import com.app.hotel.productos.model.mapper.ProductoMapper;
import com.app.hotel.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos") // Define la URL base para este controlador
public class ProductoController {

    @Autowired
    private ProductoRepository productosRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @GetMapping // Obtener todos los productos
    public ResponseEntity<List<ProductoDto>> listarTodos() {
        List<Producto> productos = productosRepository.findAll();
        List<ProductoDto> productosDto = productos.stream()
                .map(productoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productosDto); // Devuelve los productos con un estado 200 OK
    }

    @GetMapping("/{id}") // Obtener un producto por su ID
    public ResponseEntity<ProductoDto> obtenerPorId(@PathVariable int id) {
        Producto producto = productosRepository.findById(id).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no se encuentra el producto
        }
        ProductoDto productoDto = productoMapper.toDto(producto);
        return ResponseEntity.ok(productoDto); // Devuelve el producto con un estado 200 OK
    }

    @PostMapping // Crear un nuevo producto
    public ResponseEntity<ProductoDto> guardarProducto(@RequestBody ProductoDto productoDto) {
        Producto producto = productoMapper.toEntity(productoDto);
        Producto productoGuardado = productosRepository.save(producto);
        ProductoDto productoGuardadoDto = productoMapper.toDto(productoGuardado);
        return ResponseEntity.ok(productoGuardadoDto); // Devuelve el producto guardado con un estado 200 OK
    }

    @PutMapping("/{id}") // Actualizar un producto existente
    public ResponseEntity<ProductoDto> actualizarProducto(@PathVariable int id, @RequestBody ProductoDto productoDto) {
        Producto producto = productosRepository.findById(id).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no se encuentra el producto
        }
        productoMapper.setEntity(productoDto, producto); // Actualiza los valores del producto
        Producto productoActualizado = productosRepository.save(producto);
        ProductoDto productoActualizadoDto = productoMapper.toDto(productoActualizado);
        return ResponseEntity.ok(productoActualizadoDto); // Devuelve el producto actualizado con un estado 200 OK
    }

    @DeleteMapping("/{id}") // Eliminar un producto por su ID
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        Producto producto = productosRepository.findById(id).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no se encuentra el producto
        }
        productosRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // Devuelve 204 sin contenido si la eliminación fue exitosa
    }
}