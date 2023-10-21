package com.hikolu.crudrestapi.rest;

import com.hikolu.crudrestapi.entity.Driver;
import com.hikolu.crudrestapi.service.DriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriversController {

    // define a field for service
    private DriversService driversService;

    @Autowired
    public DriversController(DriversService driversService) {

        this.driversService = driversService;
    }

    // add mapping to GET and return the list of all drivers
    @GetMapping
    public List<Driver> findAll() {
        return driversService.findAll();
    }

    // add mapping to GET "/{driverId}" and return a single driver based on id
    // TODO add a check for driverId, weather it is int/is valid int if not throw exception
    @GetMapping("/{driverId}")
    public Driver findById(@PathVariable int driverId) {
        return driversService.findById(driverId);
    }

    // add mapping to PUT and return the updated driver entity
    // TODO check weather the request body contains an id and if not throw an exception
    @PutMapping
    public Driver updateDriver(@RequestBody Driver driver) {

        Driver dbDriver = driversService.save(driver);

        return dbDriver;
    }

    // add mapping to POST and return the new driver entity
    // TODO check if it contains an id and if yes throw an exception
    @PostMapping
    public Driver addNewDriver(@RequestBody Driver driver) {
        return driversService.save(driver);
    }

    // add a mapping to DELETE and return a string to display that operation was done
    // TODO add a check for driverId, weather it is int/is valid int if not throw exception
    @DeleteMapping("/{driverId}")
    public String deleteEmployee(@PathVariable int driverId) {

        driversService.deleteById(driverId);

        return "Deleted driver with id - " + driverId;
    }
}
