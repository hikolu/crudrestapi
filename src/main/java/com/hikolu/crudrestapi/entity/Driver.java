package com.hikolu.crudrestapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver {

    // define fields and connect them to database columns

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "team")
    private String team;

    // define constructors

    public Driver() {

    }

    public Driver(String firstName, String lastName, String team) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
