package com.mvc.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mvc.boot.dao.DepartamentoDao;
import com.mvc.boot.domain.Departamento;
import org.springframework.transaction.annotation.Transactional;


public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoDao dao;

    @Transactional(readOnly = false)
    @Override
    public void save(Departamento departamento) {
        dao.save(departamento);
    }
    @Transactional(readOnly = false)
    @Override
    public void update(Departamento departamento) {
        dao.update(departamento);
    }
    @Transactional(readOnly = false)
    @Override
    public void delete(Long id) {
        dao.delete(id);   
    }
    @Transactional(readOnly = true)
    @Override
    public Departamento findById(Long id) {
        return dao.findById(id);
}
    @Transactional(readOnly = true)
    @Override
    public List<Departamento> findAll() {
        return dao.findAll();
    }

}
