package ru.yandex.olejkai.xmlConf;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.yandex.olejkai.xmlConf.services.MusicPlayer;

public class Program {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context=
                     new ClassPathXmlApplicationContext("context.xml")){

        MusicPlayer musicPlayerClass=context.getBean("musicPlayerClass",MusicPlayer.class);
        musicPlayerClass.play();
        MusicPlayer musicPlayerRack=context.getBean("musicPlayerRack",MusicPlayer.class);
        musicPlayerRack.play();
        MusicPlayer musicPlayer=context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.play();
        MusicPlayer firstPayer=context.getBean("musicPlayer",MusicPlayer.class);
        firstPayer.play();
        System.out.printf("musicPlayer hash=%s,firstPayer hash=%s\n",musicPlayer.hashCode(),firstPayer.hashCode());

        }



    }
}
