package com.magno.modelo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.magno.modelo.domain.Categoria;
import com.magno.modelo.repositories.CategoriaRepository;
import com.magno.modelo.services.exceptions.DataIntegrityException;
import com.magno.modelo.services.exceptions.ObjectNotFoundException;

@Service	
public class CategoriaService {
	//injeção de dependência ou inversão de controle
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {  
		Optional<Categoria> obj = repo.findById(id); 
return obj.orElseThrow(() -> new ObjectNotFoundException(    
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));  
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);		
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);		
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível escluir uma categoria que possua produtos");
		}
	}

}
