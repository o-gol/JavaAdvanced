package ru.yandex.olejkai.javaXmlConf.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component()
@Scope("prototype")
public class ClassicMusic extends Music {
    private String name;
    private final String type="classic";
    @PostConstruct
    private void doInit(){
        System.out.println("---------------do initial-------------------");
    }
    @PreDestroy
    private void doDestr(){
        System.out.println("---------------do destroy-------------------");
    }
    @Autowired()
    public ClassicMusic(
    @Value("Bethovin-Fuga re minor")
                    String name) {
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
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
