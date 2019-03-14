package com.eduardomotos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eduardomotos.models.Produto;
import com.eduardomotos.models.Venda;
import com.eduardomotos.repository.ProdutoRepository;
import com.eduardomotos.repository.VendaRepository;

@Controller
public class VendaController {

	@Autowired
	private VendaRepository repository;
	
	@RequestMapping(value = "/vender", method = RequestMethod.GET)
	public String from() {
		return "venda/formVenda";
	}
	
	@RequestMapping(value = "/vender", method = RequestMethod.POST)
	public String from(Venda venda) {
		repository.save(venda);
		return "venda/formVenda";
	}
	
	@RequestMapping("/vendas")
	public ModelAndView listarVendas() {
		ModelAndView mv = new ModelAndView("venda/listVendas");
		Iterable<Venda> lista = repository.findAll();
		mv.addObject("vendas", lista);
		return mv;
	}
	
	@RequestMapping("/vendasEmAberto")
	public ModelAndView vendasEmAberto() {
		ModelAndView mv = new ModelAndView("venda/listVendas");
		Iterable<Venda> lista = repository.findAll();
		mv.addObject("produtos", lista);
		return mv;
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView buscarPorCodigo(@PathVariable("codigo") long codigo) {
		Venda venda = repository.findByCodigo(codigo);
		ModelAndView model = new ModelAndView("venda/detalhes"); 
		model.addObject("venda", venda);
		return model;
	}
	
	
}
