package ru.yandex.olejkai.javaXmlConf;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.yandex.olejkai.javaXmlConf.services.MusicPlayer;

public class Program {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context=
                     new ClassPathXmlApplicationContext("javaAnatContext.xml")){
//            ClassicAbstractMusic classicMusic = context.getBean("classicMusic", ClassicAbstractMusic.class);
//            System.out.println(classicMusic);
            MusicPlayer musicPlayer=context.getBean("musicPlayer",MusicPlayer.class);
            musicPlayer.play();
        }

        }
}
