package com.banco.sistema_bancario_api.dto;

public record CuentaResponseDTO(
        Long id,
        String numeroCuenta,
        Double saldo,
        String tipoCuenta
) {
}