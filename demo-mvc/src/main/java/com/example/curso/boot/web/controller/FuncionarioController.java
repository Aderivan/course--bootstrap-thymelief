package com.example.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.curso.boot.domain.Cargo;
import com.example.curso.boot.domain.Funcionario;
import com.example.curso.boot.service.CargoService;
import com.example.curso.boot.service.FuncionariosService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionariosService FuncionarioService;
	
	@Autowired
	private CargoService cargoService;
	
	@GetMapping("/cadastrar")
	public String cadastar() {
		return "funcionario/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		FuncionarioService.salvar(funcionario);
		attr.addAttribute("success", "Funcionário inserido com sucesso");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos() {
		return cargoService.buscarTodos();
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "funcionario/lista";
	}
	
	
}
