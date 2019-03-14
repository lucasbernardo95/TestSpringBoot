package com.eduardomotos.repository;

import org.springframework.data.repository.CrudRepository;

import com.eduardomotos.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String>{

//	public Produto findByCodigo(long codigo);
//	public boolean delete(long codigo);
	
}