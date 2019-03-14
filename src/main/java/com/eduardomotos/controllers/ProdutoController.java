package com.eduardomotos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eduardomotos.models.Produto;
import com.eduardomotos.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@RequestMapping(value = "/cadastrarProduto", method = RequestMethod.GET)
	public String from() {
		return "produto/formProduto";
	}
	
	@RequestMapping(value = "/cadastrarProduto", method = RequestMethod.POST)
	public String from(Produto produto) {
		repository.save(produto);
		return "produto/formProduto";
	}
	
	@RequestMapping("/produtos")
	public ModelAndView listarClientes() {
		ModelAndView mv = new ModelAndView("produto/listProdutos");
		Iterable<Produto> lista = repository.findAll();
		mv.addObject("produtos", lista);
		return mv;
	}
//	
//	@RequestMapping("/{codigo}")
//	public String buscarPorCodigo(@PathVariable("codigo") long codigo) {
//		Produto p = repository.findByCodigo(codigo);
//		ModelAndView model = new ModelAndView("produto/detalhes");
//		return "";
//	}
//	
//	@RequestMapping("/{codigo}")
//	public String deletar(@PathVariable("codigo") long codigo) {
//		return "";
//	}
	
}
