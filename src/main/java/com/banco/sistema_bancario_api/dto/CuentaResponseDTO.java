package com.banco.sistema_bancario_api.dto;

public record CuentaResponseDTO(
        String numeroCuenta,
        double saldo
) {
}