package ru.yandex.olejkai.xmlConf.objects;

public class ClassicMusic extends Music {
    private String name;
    private final String type="classic";

    private void doInit(){
        System.out.println("---------------do initial-------------------");
    }
    private void doDestr(){
        System.out.println("---------------do destroy-------------------");
    }

    public ClassicMusic(String name) {
        this.name = name;
    }

    public ClassicMusic() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ClassicAbstractMusic{" +
                "hash='" + this.hashCode() + '\'' +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
