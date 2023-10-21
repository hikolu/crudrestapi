package com.hikolu.crudrestapi.service.impl;

import com.hikolu.crudrestapi.entity.Driver;
import com.hikolu.crudrestapi.repository.DriversDAO;
import com.hikolu.crudrestapi.service.DriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DriversServiceImpl implements DriversService {

    // define a field for the dao
    private DriversDAO dao;

    // define constructors
    @Autowired
    public DriversServiceImpl(DriversDAO dao) {
        this.dao = dao;
    }

    // returns a list of all drivers
    @Override
    public List<Driver> findAll() {
        return dao.findAll();
    }

    // returns a single driver based on the id
    // TODO add Exception Handling for unexpected id
    @Override
    public Driver findById(int id) {
        return dao.findById(id);
    }

    // performs update or delete on the given driver and the returns updated/added data
    // if the id in request body is 0 -> it will add a new driver to the database
    // if it is not 0 -> it will update the information based on id
    // added @Transactional not to lose data in case of some error or simultaneous action on the database
    @Override
    @Transactional
    public Driver save(Driver driver) {
        return dao.save(driver);
    }

    // deletes a driver based on his id
    // also needs @Transactional as above

    // TODO add Exception Handling for unexpected id
    @Override
    @Transactional
    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
