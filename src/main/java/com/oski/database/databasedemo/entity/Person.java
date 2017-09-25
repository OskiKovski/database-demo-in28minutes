package com.oski.database.databasedemo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="name")
    private String name;
    private String location;
    private Date birthdate;

    public Person() {
    }

    public Person(int id, String name, String location, Date birthdate) {
        this.name = name;
        this.id = id;
        this.location = location;
        this.birthdate = birthdate;
    }

    public Person(String name, String location, Date birthdate) {
        this.id = id;
        this.location = location;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "\nPerson{" + "id=" + id + ", name='" + name + '\'' + ", location='" + location + '\'' + ", birthdate=" + birthdate + '}';
    }
}
