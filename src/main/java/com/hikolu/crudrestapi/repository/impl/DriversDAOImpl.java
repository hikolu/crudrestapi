package com.hikolu.crudrestapi.repository.impl;

import com.hikolu.crudrestapi.entity.Driver;
import com.hikolu.crudrestapi.repository.DriversDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DriversDAOImpl implements DriversDAO {

    // define a field for entity manager
    private final EntityManager entityManager;

    @Autowired
    public DriversDAOImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public List<Driver> findAll() {

        TypedQuery<Driver> query = entityManager.createQuery("from Driver", Driver.class);

        List<Driver> result = query.getResultList();

        return result;
    }

    @Override
    public Driver findById(int id) {

        Driver driver = entityManager.find(Driver.class, id);

        return driver;
    }

    @Override
    public Driver save(Driver driver) {

        Driver dbDriver = entityManager.merge(driver);

        return dbDriver;
    }

    @Override
    public void deleteById(int id) {

        Driver driver = entityManager.find(Driver.class, id);

        entityManager.remove(driver);
    }
}
