package ru.yandex.olejkai.javaAnnotConf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.yandex.olejkai.javaAnnotConf.enums.TypesEnum;
import ru.yandex.olejkai.javaAnnotConf.objects.abstractClasses.AbstractSong;
import ru.yandex.olejkai.javaAnnotConf.objects.objectClasses.Song;
import ru.yandex.olejkai.javaAnnotConf.services.MusicPlayer;
import ru.yandex.olejkai.javaAnnotConf.services.Player;
import ru.yandex.olejkai.javaAnnotConf.services.SongListFactory;
import ru.yandex.olejkai.javaAnnotConf.springConf.SpringConfig;

import java.io.IOException;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(SpringConfig.class);
        MusicPlayer player = context.getBean("player", MusicPlayer.class);
        player.play();
        System.out.println("----------------------------------------------");
        player.playRandom();
        System.out.println("----------------------------------------------");
        System.out.println(player.getAbstractMusicList());
        System.out.println(player.getAbstractSongList());



    }
}
