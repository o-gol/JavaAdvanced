package ru.yandex.olejkai.xmlConf.objects;

public class RackMusic extends Music {
    private final String type="rack";


    public RackMusic(String name) {
        super(name);
    }

    public RackMusic() {
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String toString() {
        return "RackAbstractMusic{" +
                "hash='" + this.hashCode() + '\'' +
                "name='" + super.getName() + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
