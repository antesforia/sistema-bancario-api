package com.banco.sistema_bancario_api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

//    @GetMapping("/saludo")
//    public String saludar(){
//        return "Hola desde Spring Boot";
//    }
//    @GetMapping("/banco")
//    public String bienvenida(){
//        return "Bienvenido al sistema bancario";
//    }

    private List<Cuenta> cuentas = new ArrayList<>();

    public CuentaController(){

        cuentas.add(new Cuenta("CC-001", 1500.0));
        cuentas.add(new Cuenta("CA-001", 2500));
    }

    @GetMapping
    public List<Cuenta> obtenerCuentas(){
        return cuentas;
    }

    @PostMapping
    public Cuenta crearCuenta(@RequestBody Cuenta cuenta){
        cuentas.add(cuenta);
        return cuenta;
    }

    @GetMapping("/saldo-mayor")
    public List<Cuenta>  obtenerCuentasSaldoMayor(){
        return cuentas.stream().filter(cuenta -> cuenta.getSaldo() > 2000)
                .toList();
    }
}
