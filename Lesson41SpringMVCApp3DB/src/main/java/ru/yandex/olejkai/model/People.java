package ru.yandex.olejkai.model;

import java.util.Objects;

public class People {
    private String name;
    private String surName;
    private int age;

    public People(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
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
