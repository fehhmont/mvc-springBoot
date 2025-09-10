package com.mvc.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.boot.domain.Cargo;

import org.springframework.transaction.annotation.Transactional;

import com.mvc.boot.dao.CargoDao;

@Service @Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

@Autowired
private CargoDao cargoDao;

@Override
public void save(Cargo cargo) {
    cargoDao.save(cargo);
}
@Override
public void update(Cargo cargo) {
    cargoDao.update(cargo);
}
@Override
public void delete(Long id) {
    cargoDao.delete(id);   
}
@Override @Transactional(readOnly = true)
public Cargo findById(Long id) {
    return cargoDao.findById(id);
}
@Override @Transactional(readOnly = true)
public List<Cargo> findAll() {
    return cargoDao.findAll();
}

}
