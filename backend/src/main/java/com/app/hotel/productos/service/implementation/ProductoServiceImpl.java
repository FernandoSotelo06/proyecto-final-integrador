package com.app.hotel.productos.service.implementation;

import com.app.hotel.productos.model.dto.ProductoDto;
import com.app.hotel.productos.model.entity.Producto;
import com.app.hotel.productos.model.mapper.ProductoMapper;
import com.app.hotel.productos.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public List<ProductoDto> listarTodos() {
        List<Producto> productos = productoRepository.findAll();
        Stream<ProductoDto> streamDto = productos.stream().map(productoMapper::toDto);
        return streamDto.collect(Collectors.toList());
    }

    @Override
    public Page<ProductoDto> paginar(Pageable pageable) {
        Page<Producto> productosPage = productoRepository.findAll(pageable);
        return productosPage.map(productoMapper::toDto);
    }

    @Override
    public ProductoDto obtenerPorId(Integer id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el producto con ID: " + id));
        return productoMapper.toDto(producto);
    }

    @Override
    @Transactional
    public ProductoDto guardarProducto(ProductoDto productoDto) {
        if (productoDto == null) throw new IllegalArgumentException("El DTO no puede ser nulo");
        Producto producto = productoMapper.toEntity(productoDto);
        Producto productoGuardado = productoRepository.save(producto);
        return productoMapper.toDto(productoGuardado);
    }

    @Override
    @Transactional
    public ProductoDto actualizarProducto(Integer id, ProductoDto productoDto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el producto con ID: " + id));
        productoMapper.setEntity(productoDto, producto);  // Actualizamos los datos de la entidad
        Producto productoActualizado = productoRepository.save(producto);
        return productoMapper.toDto(productoActualizado);
    }

    @Override
    @Transactional
    public void eliminarProducto(Integer id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el producto con ID: " + id));
        productoRepository.deleteById(producto.getId());
    }
}