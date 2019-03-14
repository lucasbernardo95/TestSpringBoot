package com.eduardomotos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eduardomotos.models.Cliente;
import com.eduardomotos.repository.ClienteRepository;

//responsável por 'atender' as requisições feitas a aplicação
@Controller
public class ClienteController {

	//Realiza uma injeção do objeto clienteRepository para fornecer os métodos do crud
	@Autowired
	private ClienteRepository repository;
	
	//quando houver uma requisição para /cadastrarCliente, retorna a página para o usuário
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
	public String from() {
		return "cliente/formCliente";
	}
	
	//invocado quando o usuário clicar no botão salvar, no formulário de cadastro de clientes
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String from(Cliente cliente) {
		repository.save(cliente);
		return "cliente/formCliente";
	}
	
	//resposável por retornar a lista de clientes
	@RequestMapping("/clientes")
	public ModelAndView listarClientes() {
		//informa qual página que deve ser renderizada de acordo com o dado do objeto 'cliente'
		ModelAndView mv = new ModelAndView("index");
		Iterable<Cliente> lista = repository.findAll();
		//'clientes' é o nome da lista de objetos que foi informado na página index.html
		//converte a lista de eventos do banco para view e retorna
		mv.addObject("clientes", lista);
		return mv;
	}
	
}