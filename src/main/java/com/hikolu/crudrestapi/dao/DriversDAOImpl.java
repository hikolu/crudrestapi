package com.hikolu.crudrestapi.dao;

import com.hikolu.crudrestapi.entity.Driver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DriversDAOImpl implements DriversDAO {

    // define a field for entity manager
    private final EntityManager entityManager;

    // define constructor
    @Autowired
    public DriversDAOImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    // returns a list of all drivers
    @Override
    public List<Driver> findAll() {

        TypedQuery<Driver> query = entityManager.createQuery("from Driver", Driver.class);

        List<Driver> result = query.getResultList();

        return result;
    }

    // returns a single driver based on the id
    // TODO add Exception Handling for unexpected id
    @Override
    public Driver findById(int id) {

        Driver driver = entityManager.find(Driver.class, id);

        return driver;
    }

    // performs update or delete on the given driver and the returns updated/added data
    // if the id in request body is 0 -> it will add a new driver to the database
    // if it is not 0 -> it will update the information based on id
    // added @Transactional not to lose data in case of some error or simultaneous action on the database
    @Override
    @Transactional
    public Driver save(Driver driver) {

        Driver dbDriver = entityManager.merge(driver);

        return dbDriver;
    }

    // deletes a driver based on his id
    // also needs @Transactional as above

    // TODO add Exception Handling for unexpected id
    @Override
    public void deleteById(int id) {

        Driver driver = entityManager.find(Driver.class, id);

        entityManager.remove(driver);
    }
}
