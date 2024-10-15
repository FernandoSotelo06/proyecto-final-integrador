package com.app.hotel.productos.model.mapper;
import com.app.hotel.productos.model.dto.ProductoDto;
import com.app.hotel.productos.model.entity.Producto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ProductoMapper {


    public ProductoDto toDto(Producto entity) {
        ProductoDto.ProductoDtoBuilder dtoBuilder = ProductoDto.builder();

        dtoBuilder.id(entity.getId());
        dtoBuilder.nombre(entity.getNombre());
        dtoBuilder.descripcion(entity.getDescripcion());
        dtoBuilder.precio(entity.getPrecio());
        dtoBuilder.stock(entity.getStock());

        return dtoBuilder.build();
    }


    public Producto toEntity(ProductoDto dto) {
        Producto entity = new Producto();

        entity.setId(dto.getId());
        setEntity(dto, entity);

        return entity;
    }


    public void setEntity(ProductoDto dto, Producto entity) {
        setDtoToEntity(dto, entity);
    }


    private void setDtoToEntity(ProductoDto dto, Producto entity) {
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecio(dto.getPrecio());
        entity.setStock(dto.getStock());
    }
}