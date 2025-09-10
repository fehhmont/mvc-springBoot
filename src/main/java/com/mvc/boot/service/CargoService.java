package com.mvc.boot.service;

import java.util.List;
import com.mvc.boot.domain.Cargo;

public interface CargoService {

void save(Cargo cargo);
void update(Cargo cargo);
void delete(Long id);
Cargo findById(Long id);
List<Cargo> findAll();


}
