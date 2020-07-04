package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Cliente;
import com.example.demo.service.ClienteService;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    ClienteService clienteservice;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Cliente cliente = clienteservice.find(id);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("Cliente", cliente);
        map.put("Endereço(s)", cliente.getEnderecos());
        map.put("Conta(s)", cliente.getContas());
        return ResponseEntity.ok().body(map);
    }

}
