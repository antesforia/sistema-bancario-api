package com.banco.sistema_bancario_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CuentaRequestDTO(
        @NotBlank(message="El número de cuenta es obligatorio.")
        String numeroCuenta,
        @NotNull(message="El saldo es obligatorio.")
        Double saldo,
        @NotBlank(message = "Debe ingresar el tipo de cuenta")
        String tipoCuenta
) {
}