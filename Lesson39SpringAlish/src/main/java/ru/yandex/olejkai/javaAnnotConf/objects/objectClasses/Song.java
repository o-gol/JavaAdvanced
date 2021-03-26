package ru.yandex.olejkai.javaAnnotConf.objects.objectClasses;

import ru.yandex.olejkai.javaAnnotConf.enums.TypesEnum;
import ru.yandex.olejkai.javaAnnotConf.objects.abstractClasses.AbstractSong;

public class Song extends AbstractSong {

    public Song(String name, TypesEnum type) {
        super(name, type);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
