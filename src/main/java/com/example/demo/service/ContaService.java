package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Conta;
import com.example.demo.repository.ContaRepository;
import com.example.demo.service.exception.ObjectNotFoundException;

import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contarepositoriy;

    public Conta find(Integer id) {
        Optional<Conta> conta = contarepositoriy.findById(id);
        return conta.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado conta com o id: ID.".replace("ID", Integer.toString(id))));
    }
}
