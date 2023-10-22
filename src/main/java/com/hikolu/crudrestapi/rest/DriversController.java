package com.hikolu.crudrestapi.rest;

import com.hikolu.crudrestapi.entity.Driver;
import com.hikolu.crudrestapi.exception.BadRequestException;
import com.hikolu.crudrestapi.exception.DriverNotFoundException;
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
    @GetMapping("/{driverId}")
    public Driver findById(@PathVariable int driverId) {

        Driver driver = driversService.findById(driverId);

        if (driver == null) {
            throw new DriverNotFoundException("Driver id not found, id - " + driverId);
        }

        return driversService.findById(driverId);
    }

    // add mapping to PUT and return the updated driver entity
    @PutMapping
    public Driver updateDriver(@RequestBody Driver driver) {

        if (driver.getId() == 0) {
            throw new BadRequestException("Given request body doesn't contain id");
        }

        Driver dbDriver = driversService.findById(driver.getId());

        if (dbDriver == null) {
            throw new DriverNotFoundException("Driver not found, id - " + driver.getId());
        }

        return driversService.save(driver);
    }

    // add mapping to POST and return the new driver entity
    @PostMapping
    public Driver addNewDriver(@RequestBody Driver driver) {

        if (driver.getId() != 0) {
            throw new BadRequestException("Given request body contains id");
        }

        return driversService.save(driver);
    }

    // add a mapping to DELETE and return a string to display that operation was done
    @DeleteMapping("/{driverId}")
    public String deleteEmployee(@PathVariable int driverId) {

        Driver driver = driversService.findById(driverId);

        if (driver == null) {
            throw new DriverNotFoundException("Driver not found, id - " + driverId);
        }

        driversService.deleteById(driverId);

        return "Deleted driver with id - " + driverId;
    }
}
