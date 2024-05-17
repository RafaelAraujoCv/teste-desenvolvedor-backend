package com.teste.santander.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.santander.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    
}
