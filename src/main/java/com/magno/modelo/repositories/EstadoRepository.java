package com.magno.modelo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magno.modelo.domain.Estado;

/*
 * Camada de acesso a dados (Repository)
 * */

@Repository
public interface EstadoRepository  extends JpaRepository<Estado, Integer>{

}
