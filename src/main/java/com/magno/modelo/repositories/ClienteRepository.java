package com.magno.modelo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magno.modelo.domain.Cliente;

/*
 * Camada de acesso a dados (Repository)
 * */

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	Cliente findByEmail(String email);

}
