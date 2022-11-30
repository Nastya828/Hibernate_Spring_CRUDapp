package ru.iakimova.springcourse.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name should between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 3, max = 30, message = "Lastname should between 2 and 30 characters")
    @Column(name = "lastname")
    private String lastname;

    @Min(value = 0, message = "Age should be greater than 0")
    @Column(name = "age")
    private int age;

    public Person() {
    }

    public Person( String name, int age, String email, String address) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
