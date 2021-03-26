package ru.yandex.olejkai.javaAnnotConf.objects.objectClasses;

import ru.yandex.olejkai.javaAnnotConf.enums.TypesEnum;
import ru.yandex.olejkai.javaAnnotConf.objects.abstractClasses.AbstractMusic;

public class RapAbstractMusic extends AbstractMusic {
    private final TypesEnum type=TypesEnum.RAP;

    public TypesEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RapAbstractMusic{" +
                "hash='" + this.hashCode() + '\'' +
                "songs='" + super.getSongs() + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
