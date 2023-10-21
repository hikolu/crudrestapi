package com.hikolu.crudrestapi.service;

import com.hikolu.crudrestapi.entity.Driver;

import java.util.List;

public interface DriversService {

    List<Driver> findAll();

    Driver findById(int id);

    Driver save(Driver driver);

    void deleteById(int id);
}
