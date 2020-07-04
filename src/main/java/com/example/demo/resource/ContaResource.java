package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Conta;
import com.example.demo.service.ContaService;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {

    @Autowired
    ContaService contaservice;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Conta conta = contaservice.find(id);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("Conta", conta);
        map.put("Categoria", conta.getCategoria());
        map.put("Cartões", conta.getCartoes());
        return ResponseEntity.ok().body(map);
    }
}
