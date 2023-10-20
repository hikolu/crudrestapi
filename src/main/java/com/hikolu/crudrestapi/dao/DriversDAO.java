package com.hikolu.crudrestapi.dao;

import com.hikolu.crudrestapi.entity.Driver;

import java.util.List;

public interface DriversDAO {

    // define abstract methods for basic functionality

    List<Driver> findAll();

    Driver findById(int id);

    Driver save(Driver driver);

    void deleteById(int id);
}
