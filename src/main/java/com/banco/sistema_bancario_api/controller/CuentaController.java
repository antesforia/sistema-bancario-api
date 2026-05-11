package com.banco.sistema_bancario_api.controller;

import com.banco.sistema_bancario_api.dto.CuentaRequestDTO;
import com.banco.sistema_bancario_api.dto.CuentaResponseDTO;
import com.banco.sistema_bancario_api.model.Cuenta;
import com.banco.sistema_bancario_api.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    private final CuentaService cuentaService;

    public CuentaController (CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }


    @GetMapping
    public List<CuentaResponseDTO> obtenerCuentas(){
        return cuentaService.obtenerCuenta();
    }

    @PostMapping
    public CuentaResponseDTO crearCuenta(
            @Valid @RequestBody CuentaRequestDTO request
    ){
        return cuentaService.crearCuenta(request);
    }

    @GetMapping("/saldo-mayor")
    public List<CuentaResponseDTO>  obtenerCuentasSaldoMayor(){
        return cuentaService.obtenerCuentaSueldoMayor();
    }

    @GetMapping("/tipo/{tipoCuenta}")
    public List<CuentaResponseDTO> obtenerPorTipoCuenta(
            @PathVariable String tipoCuenta
    ){
        return cuentaService.obtenerPorTipoCuenta(tipoCuenta);
    }

    @PutMapping ("/{id}")
    public CuentaResponseDTO actualizarCuenta(
            @PathVariable Long id,
            @Valid @RequestBody CuentaRequestDTO request
    ){
        return cuentaService.actualizarCuenta(id, request);
    }

    @DeleteMapping ("/{id}")
    public void eliminarCuenta(
            @PathVariable Long id
    ){
        cuentaService.eliminarCuenta(id);
    }
}
