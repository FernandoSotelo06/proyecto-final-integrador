package com.app.hotel.auth.controller;

import com.app.hotel.auth.model.dto.AuthUsuarioDto;
import com.app.hotel.auth.service.AuthService;
import com.app.hotel.auth.service.AuthServiceImpl;
import com.app.hotel.common.responses.ResponseFactory;
import com.app.hotel.samples.model.dto.SampleDto;
import com.app.hotel.samples.service.SampleServiceImpl;
import com.app.hotel.usuarios.model.dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping
    public ResponseEntity<?> registrarCuenta(@RequestBody AuthUsuarioDto authUsuarioDto) {
        AuthUsuarioDto result = authService.registrarCuenta(authUsuarioDto);

        ResponseFactory<SampleDto> response = ResponseFactory.success("Registrado correctamente", result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
