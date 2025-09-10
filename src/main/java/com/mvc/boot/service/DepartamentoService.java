package com.mvc.boot.service;

import java.util.List;
import com.mvc.boot.domain.Departamento;

public interface DepartamentoService {
void save(Departamento departamento);
void update(Departamento departamento);
void delete(Long id);
Departamento findById(Long id);
List<Departamento> findAll();

}
