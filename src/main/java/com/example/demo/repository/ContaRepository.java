package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
}
