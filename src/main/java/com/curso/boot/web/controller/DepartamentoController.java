package com.curso.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap; // Adicionar este import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mvc.boot.domain.Departamento;
import com.mvc.boot.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping("/cadastrar")
    public String Cadastrar(Departamento departamento) {
        return "/departamento/cadastro";
    }

    // Método listar atualizado
    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("departamentos", service.findAll());
        return "/departamento/lista";
    }
    
    @PostMapping("/salvar")
    public String salvar(Departamento departamento) {
        service.save(departamento);
        return "redirect:/departamentos/cadastrar";
    }
}