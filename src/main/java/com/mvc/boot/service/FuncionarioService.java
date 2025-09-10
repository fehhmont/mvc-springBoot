package com.mvc.boot.service;

import java.util.List;

import com.mvc.boot.domain.Funcionario;

public interface FuncionarioService {
    void save(Funcionario funcionario);
    void update(Funcionario funcionario);
    void delete(Long id);
    Funcionario findById(Long id);
    List<Funcionario> findAll();
    

}
