package com.eduardomotos.repository;

import org.springframework.data.repository.CrudRepository;

import com.eduardomotos.models.Venda;

public interface VendaRepository extends CrudRepository<Venda, String> {

	public Venda findByCodigo(long codigo);
	
}