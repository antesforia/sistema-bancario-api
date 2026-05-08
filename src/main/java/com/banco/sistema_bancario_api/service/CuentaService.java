package com.banco.sistema_bancario_api.service;

import com.banco.sistema_bancario_api.dto.CuentaRequestDTO;
import com.banco.sistema_bancario_api.dto.CuentaResponseDTO;
import com.banco.sistema_bancario_api.model.Cuenta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuentaService {

    private List<Cuenta> cuentas = new ArrayList<>();

    public CuentaService(){
        cuentas.add(new Cuenta ("CC-001", 1200.0, "AHORRO"));
        cuentas.add(new Cuenta ("CA-001", 1500.0, "CORRIENTE"));
    }

    public List<CuentaResponseDTO> obtenerCuenta(){

        return cuentas.stream()
                .map(cuenta -> new CuentaResponseDTO(
                    cuenta.getNumeroCuenta(),
                    cuenta.getSaldo(), cuenta.getTipoCuenta()
                    ))
                    .toList();
    }

    public CuentaResponseDTO crearCuenta(CuentaRequestDTO request){
        Cuenta cuenta = new Cuenta (
        request.numeroCuenta(), request.saldo(), request.tipoCuenta()
        );

        cuentas.add(cuenta);
        return new CuentaResponseDTO(
                cuenta.getNumeroCuenta(),
                cuenta.getSaldo(), cuenta.getTipoCuenta()
        );
    }

    public List<CuentaResponseDTO> obtenerCuentaSueldoMayor(){
        return cuentas.stream()
                .filter(cuenta -> cuenta.getSaldo() > 1000.0)
                .map(cuenta -> new CuentaResponseDTO(
                        cuenta.getNumeroCuenta(),
                        cuenta.getSaldo(),
                        cuenta.getTipoCuenta()
                ))
                .toList();
    }
}
