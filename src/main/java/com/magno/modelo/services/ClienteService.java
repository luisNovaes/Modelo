package com.magno.modelo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magno.modelo.domain.Cliente;
import com.magno.modelo.repositories.ClienteRepository;
import com.magno.modelo.services.exceptions.ObjectNotFoundException;

@Service	
public class ClienteService {
	//injeção de dependência ou inversão de controle
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {  
		Optional<Cliente> obj = repo.findById(id); 
return obj.orElseThrow(() -> new ObjectNotFoundException(    
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));  
	}

}
