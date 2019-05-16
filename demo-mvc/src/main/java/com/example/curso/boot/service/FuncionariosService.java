package com.example.curso.boot.service;

import java.util.List;

import com.example.curso.boot.domain.Funcionario;

public interface FuncionariosService {
	
	void salvar (Funcionario funcionario);
	
	void editar (Funcionario funcionario);
	
	void excluir (Long id);
	
	Funcionario buscarPorId(Long id);
	
	List<Funcionario> buscarTodos();
}	
