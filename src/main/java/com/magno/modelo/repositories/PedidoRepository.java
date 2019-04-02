package com.magno.modelo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magno.modelo.domain.Pedido;

/*
 * Camada de acesso a dados (Repository)
 * */

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Integer>{

}
