package com.app.hotel.auth.service;

import com.app.hotel.auth.model.dto.AuthUsuarioDto;
import com.app.hotel.usuarios.model.dto.UsuarioDto;
import org.springframework.stereotype.Component;

@Component
public interface AuthService {
    AuthUsuarioDto registrarCuenta(AuthUsuarioDto authUsuarioDto);

    AuthUsuarioDto iniciarSesion(String username, String password);

    Boolean cerrarSesion();

    Boolean recuperarContrasenia();

    Boolean resetearContrasenia();
}
