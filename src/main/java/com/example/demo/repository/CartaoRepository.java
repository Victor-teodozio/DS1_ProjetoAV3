package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
}

