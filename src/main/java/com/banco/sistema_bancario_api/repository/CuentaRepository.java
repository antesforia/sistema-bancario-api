package com.banco.sistema_bancario_api.repository;

import com.banco.sistema_bancario_api.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    List<Cuenta> findByTipoCuenta(String tipoCuenta);

}
