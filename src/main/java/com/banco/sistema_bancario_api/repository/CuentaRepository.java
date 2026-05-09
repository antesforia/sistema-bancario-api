package com.banco.sistema_bancario_api.repository;

import com.banco.sistema_bancario_api.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

}
