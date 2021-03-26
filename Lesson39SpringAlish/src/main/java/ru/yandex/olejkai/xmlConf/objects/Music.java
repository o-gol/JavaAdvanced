package ru.yandex.olejkai.xmlConf.objects;

public abstract class Music {
    private  String type;
    private  String name;

    public Music(String name) {
        this.name = name;
    }

    public Music() {
    }

    public  String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractMusic{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
