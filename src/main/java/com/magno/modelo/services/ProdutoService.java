package com.magno.modelo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.magno.modelo.domain.Categoria;
import com.magno.modelo.domain.Produto;
import com.magno.modelo.repositories.CategoriaRepository;
import com.magno.modelo.repositories.ProdutoRepository;
import com.magno.modelo.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	// injeção de dependência ou inversão de controle
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy); 
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainigAndCategoriasIn(nome, categorias, pageRequest);
			
	}
	
	
	
	

}
