package ru.yandex.olejkai.model;

import java.io.Serializable;
import java.util.Objects;

public class People implements Serializable {
    private static int globId;
    private int id;
    private String name;
    private String surName;
    private int age;

    public People() {
    }

    public People(String name, String surName, int age) {
        globId++;
        this.id=globId;
        this.name = name;
        this.surName = surName;
        this.age = age;
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
                "id="+id+'\''+
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age &&
                name.equals(people.name) &&
                surName.equals(people.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, age);
    }
}
