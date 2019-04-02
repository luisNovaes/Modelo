package com.magno.modelo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magno.modelo.domain.Pedido;
import com.magno.modelo.repositories.PedidoRepository;
import com.magno.modelo.services.exceptions.ObjectNotFoundException;

@Service	
public class PedidoService {
	//injeção de dependência ou inversão de controle
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {  
		Optional<Pedido> obj = repo.findById(id); 
return obj.orElseThrow(() -> new ObjectNotFoundException(    
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));  
	}

}
