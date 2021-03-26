package ru.yandex.olejkai.javaAnnotConf.objects.abstractClasses;

import ru.yandex.olejkai.javaAnnotConf.enums.TypesEnum;

public abstract class AbstractSong {
    private final String name;
    private final TypesEnum type;

    public AbstractSong(String name, TypesEnum type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public TypesEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return "AbstractSong{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
