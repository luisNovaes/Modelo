package com.magno.modelo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magno.modelo.domain.Categoria;
import com.magno.modelo.repositories.CategoriaRepository;
import com.magno.modelo.services.exceptions.ObjectNotFoundException;

@Service	
public class CategoriaService {
	//injeção de dependência ou inversão de controle
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {  
		Optional<Categoria> obj = repo.findById(id); 
return obj.orElseThrow(() -> new ObjectNotFoundException(    
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));  
	}

}
