package ru.yandex.olejkai.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name="people")
@DynamicInsert
@DynamicUpdate
public class People implements Serializable {
    private static int globId;

    @Id
    @Column(name="id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name is empty...")
    @Size(
            min = 2,
            max = 20,
            message = "must be between {min} and {max} characters long"
    )
    private String name;

    @Column(name="surname")
    @NotEmpty(message = "Surname is empty...")
    @Size(
            min = 2,
            max = 20,
            message = "must be between {min} and {max} characters long"
    )
    private String surName;

    @Column(name="email")
    @NotEmpty(message = "Email is empty...")
    @Email(message = "It's not email...")
    @Size(
            min = 2,
            max = 20,
            message = "must be between 2 and 20 characters long"
    )
    private String email;

    @Column(name="age")
    //@NotEmpty(message = "age is empty")
    @Min(value = 0, message = "min 0")
    private int age;

    public People() {
    }

    public People(String name, String surName, int age, String email) {
        //globId++;
        //this.id = globId;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.age = age;
    }
    public People(int id,String name, String surName, int age, String email) {
        globId++;
        this.id = globId;
        this.name = name;
        this.surName = surName;
        this.email = email;
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

    public boolean isEmpty() {
        if (this.id == 0 && this.name == null && this.surName == null && this.age == 0)
            return true;
        else
            return false;
    }
}
