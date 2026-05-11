package com.banco.sistema_bancario_api.controller;

import com.banco.sistema_bancario_api.dto.ClienteRequestDTO;
import com.banco.sistema_bancario_api.dto.ClienteResponseDTO;
import com.banco.sistema_bancario_api.model.Cliente;
import com.banco.sistema_bancario_api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController (ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteResponseDTO> obtenerClientes(){
        return clienteService.obtenerClientes();
    }

    @PostMapping
    public ClienteResponseDTO crearCliente(
            @Valid @RequestBody ClienteRequestDTO request
            ){

        return clienteService.crearCliente(request); // Placeholder, se debe reemplazar con la implementación real.
    }
}
