package ru.yandex.olejkai.model;



import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Objects;

public class People implements Serializable {
    private static int globId;

    private int id;


    @NotEmpty(message = "Name is empty...")
    private String name;


    @NotEmpty(message = "Surname is empty...")
    private String surName;


    @NotEmpty(message = "Email is empty...")
    @Email(message = "It's not email...")
    private String email;


    @NotEmpty(message = "Age is empty...")
    @Size(
            min = 2,
            max = 130,
            message = "The license plate '${validatedValue}' must be between {min} and {max} characters long"
    )
    private int age;

    public People() {
    }

    public People(String name, String surName, int age, String email) {
        globId++;
        this.id=globId;
        this.name = name;
        this.surName = surName;
        this.email=email;
        this.age = age;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void setGlobId(int globId) {
        People.globId = globId;
    }

    public static int getGlobId() {
        return globId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return id == people.id &&
                age == people.age &&
                name.equals(people.name) &&
                surName.equals(people.surName) &&
                email.equals(people.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surName, email, age);
    }
}
