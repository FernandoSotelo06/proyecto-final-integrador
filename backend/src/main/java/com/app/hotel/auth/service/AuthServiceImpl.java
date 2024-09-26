package com.app.hotel.auth.service;

import com.app.hotel.auth.model.dto.AuthUsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthUsuarioDto registrarCuenta(AuthUsuarioDto authUsuarioDto) {
        return null;
    }

    @Override
    public AuthUsuarioDto iniciarSesion(String username, String password) {
        return null;
    }

    @Override
    public Boolean cerrarSesion() {
        return null;
    }

    @Override
    public Boolean recuperarContrasenia() {
        return null;
    }

    @Override
    public Boolean resetearContrasenia() {
        return null;
    }
}
