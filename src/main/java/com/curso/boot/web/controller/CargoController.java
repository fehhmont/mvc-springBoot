package com.curso.boot.web.controller;

import java.util.List; // Adicionar import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute; // Adicionar import
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mvc.boot.domain.Cargo;
import com.mvc.boot.domain.Departamento; // Adicionar import
import com.mvc.boot.service.CargoService;
import com.mvc.boot.service.DepartamentoService; // Adicionar import

@Controller
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;
    @Autowired
    private DepartamentoService departamentoService;
    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo) {
        return "/cargo/cadastro";
    }
    
    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("cargos", cargoService.findAll()); // Esta linha busca e envia os dados
        return "/cargo/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Cargo cargo) {
        cargoService.save(cargo);
        return "redirect:/cargos/cadastrar";
    }
    
    @ModelAttribute("departamentos") // Este método será chamado antes de qualquer outro no controller
    public List<Departamento> listaDeDepartamentos() {
        return departamentoService.findAll();
    }
}