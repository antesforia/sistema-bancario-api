package com.banco.sistema_bancario_api.service;

import com.banco.sistema_bancario_api.dto.CuentaRequestDTO;
import com.banco.sistema_bancario_api.dto.CuentaResponseDTO;
import com.banco.sistema_bancario_api.model.Cuenta;
import com.banco.sistema_bancario_api.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository){
        this.cuentaRepository = cuentaRepository;
    }

    public List<CuentaResponseDTO> obtenerCuenta(){

        return cuentaRepository.findAll()
                .stream()
                .map(cuenta -> new CuentaResponseDTO(cuenta.getId(),
                    cuenta.getNumeroCuenta(),
                    cuenta.getSaldo(), cuenta.getTipoCuenta()
                    ))
                    .toList();
    }

    public CuentaResponseDTO crearCuenta(CuentaRequestDTO request){
        Cuenta cuenta = new Cuenta (
        request.numeroCuenta(), request.saldo(), request.tipoCuenta()
        );

        Cuenta cuentaGuardada = cuentaRepository.save(cuenta);
        return new CuentaResponseDTO(cuentaGuardada.getId(),
                cuentaGuardada.getNumeroCuenta(),
                cuenta.getSaldo(), cuenta.getTipoCuenta()
        );
    }

    public List<CuentaResponseDTO> obtenerCuentaSueldoMayor(){
        return cuentaRepository.findAll().stream()
                .filter(cuenta -> cuenta.getSaldo() > 1000.0)
                .map(cuenta -> new CuentaResponseDTO(
                        cuenta.getId(),
                        cuenta.getNumeroCuenta(),
                        cuenta.getSaldo(),
                        cuenta.getTipoCuenta()
                ))
                .toList();
    }
}
