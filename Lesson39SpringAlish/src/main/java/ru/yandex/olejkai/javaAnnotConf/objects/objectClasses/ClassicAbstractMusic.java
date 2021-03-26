package ru.yandex.olejkai.javaAnnotConf.objects.objectClasses;

import ru.yandex.olejkai.javaAnnotConf.enums.TypesEnum;
import ru.yandex.olejkai.javaAnnotConf.objects.abstractClasses.AbstractMusic;

public class ClassicAbstractMusic extends AbstractMusic {
    private final TypesEnum type=TypesEnum.CLASSIC;

    private void doInit(){
        System.out.println("---------------do initial-------------------");
    }
    private void doDestr(){
        System.out.println("---------------do destroy-------------------");
    }







    @Override
    public TypesEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ClassicAbstractMusic{" +
                "hash='" + this.hashCode() + '\'' +
                "songs='" + super.getSongs() + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
