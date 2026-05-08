package com.banco.sistema_bancario_api.dto;

public record CuentaRequestDTO(
        String numeroCuenta,
        double saldo,
        String tipoCuenta
) {
}