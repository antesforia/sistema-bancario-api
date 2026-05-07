package com.banco.sistema_bancario_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CuentaController {

//    @GetMapping("/saludo")
//    public String saludar(){
//        return "Hola desde Spring Boot";
//    }
//    @GetMapping("/banco")
//    public String bienvenida(){
//        return "Bienvenido al sistema bancario";
//    }

    @GetMapping("/cuenta")
    public Cuenta mostrarDatos(){
        return new Cuenta("CC-001", 1500);
    }
}
