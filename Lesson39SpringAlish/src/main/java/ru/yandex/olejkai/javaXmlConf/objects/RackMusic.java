package ru.yandex.olejkai.javaXmlConf.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RackMusic extends Music {
    private final String type="rack";
//    @Value("Ramstain-Du Hust")
//    private String name;
    @Autowired
    public RackMusic(
            @Value("Ramstain-Du Hust")
//            @Qualifier("Ramstain-Du Hust")
                             String name) {
        super(name);
//        this.name=name;
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
                ", name='" + super.getName() + '\'' +
//                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
