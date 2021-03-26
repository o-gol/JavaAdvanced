package ru.yandex.olejkai.javaAnnotConf.objects.objectClasses;

import ru.yandex.olejkai.javaAnnotConf.enums.TypesEnum;
import ru.yandex.olejkai.javaAnnotConf.objects.abstractClasses.AbstractMusic;

public class RackAbstractMusic extends AbstractMusic {
    private final TypesEnum type=TypesEnum.RACK;




    @Override
    public TypesEnum getType() {
        return type;
    }



    @Override
    public String toString() {
        return "RackAbstractMusic{" +
                "hash='" + this.hashCode() + '\'' +
                "songs='" + super.getSongs() + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
