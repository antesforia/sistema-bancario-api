package com.banco.sistema_bancario_api.controller;

import com.banco.sistema_bancario_api.service.CuentaService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    private final CuentaService cuentaService;

    public CuentaController (CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }


    @GetMapping
    public List<Cuenta> obtenerCuentas(){
        return cuentaService.obtenerCuenta();
    }

    @PostMapping
    public Cuenta crearCuenta(@RequestBody Cuenta cuenta){
        return cuentaService.crearCuenta(cuenta);
    }

    @GetMapping("/saldo-mayor")
    public List<Cuenta>  obtenerCuentasSaldoMayor(){
        return cuentaService.obtenerCuentaSueldoMayor();
    }
}
