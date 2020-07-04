package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.exception.ObjectNotFoundException;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienterepository;

    public Cliente find(Integer id) {
        Optional<Cliente> cliente = clienterepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado cliente com o id: ID.".replace("ID", Integer.toString(id))));
    }
}
