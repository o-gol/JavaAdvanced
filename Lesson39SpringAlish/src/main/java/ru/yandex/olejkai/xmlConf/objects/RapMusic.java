package ru.yandex.olejkai.xmlConf.objects;

public class RapMusic extends Music {
    private final String type="rap";

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RapAbstractMusic{" +
                "hash='" + this.hashCode() + '\'' +
                "name='" + super.getName() + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
