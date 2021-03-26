package ru.yandex.olejkai.javaXmlConf.objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RapMusic extends Music {
    private final String type="rap";

    public RapMusic(@Value("Eminem-Luse") String name) {
        super(name);
    }

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
