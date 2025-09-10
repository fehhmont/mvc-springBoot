package com.mvc.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mvc.boot.dao.FuncionarioDao;
import com.mvc.boot.domain.Funcionario;


@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

@Autowired
private FuncionarioDao dao;

@Transactional(readOnly = false)
@Override
public void save(Funcionario funcionario) {
    dao.save(funcionario);
}

@Transactional(readOnly = false)
@Override
public void update(Funcionario funcionario) {
    dao.update(funcionario);
}
@Transactional(readOnly = false)
@Override
public void delete(Long id) {
    dao.delete(id);   
}
@Override
public Funcionario findById(Long id) {
    return dao.findById(id);

}
@Override
public List<Funcionario> findAll() {
    return dao.findAll();
}

}
