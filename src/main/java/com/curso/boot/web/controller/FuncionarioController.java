package com.curso.boot.web.controller;

import com.mvc.boot.domain.Cargo;
import com.mvc.boot.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder; // Adicionar import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder; // Adicionar import
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mvc.boot.domain.Funcionario;
import com.mvc.boot.service.FuncionarioService;
import java.beans.PropertyEditorSupport; // Adicionar import
import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private CargoService cargoService;

    @InitBinder // Adicionado para converter o salário
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Double.class, "salario", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text != null && !text.isEmpty()) {
                    // Substitui o ponto de milhar e a vírgula do decimal
                    text = text.replace(".", "").replace(",", ".");
                }
                setValue(Double.parseDouble(text));
            }
        });
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario) {
        return "/funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "/funcionario/lista";
    }
    
    @PostMapping("/salvar")
    public String salvar(Funcionario funcionario) {
        funcionarioService.save(funcionario);
        return "redirect:/funcionarios/cadastrar";
    }

    @ModelAttribute("cargos")
    public List<Cargo> getCargos() {
        return cargoService.findAll();
    }
}