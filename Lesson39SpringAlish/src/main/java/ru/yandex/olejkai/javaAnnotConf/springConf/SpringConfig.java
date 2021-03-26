package ru.yandex.olejkai.javaAnnotConf.springConf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.yandex.olejkai.javaAnnotConf.enums.TypesEnum;
import ru.yandex.olejkai.javaAnnotConf.objects.abstractClasses.AbstractSong;
import ru.yandex.olejkai.javaAnnotConf.objects.objectClasses.Song;
import ru.yandex.olejkai.javaAnnotConf.services.MusicPlayer;
import ru.yandex.olejkai.javaAnnotConf.services.Player;
import ru.yandex.olejkai.javaAnnotConf.services.SongListFactory;

import java.io.IOException;
import java.util.List;

@Configuration
@ComponentScan("ru.yandex.olejkai.javaAnnotConf")
@PropertySource("classpath:songs.properties")
public class SpringConfig {

   /* @Value("${song1.type}")
    TypesEnum typesEnum;
    @Value("${song1.name}")
    String name;

    @Bean
    public AbstractSong abstractSong(){
        return
                new Song(name, typesEnum);
    }*/

    @Bean
    public List<AbstractSong> songsCreater() throws IOException {
        return SongListFactory.songsCreator("D:\\Java_projekts\\UdemyJavaAdvanced\\Lesson39SpringAlish\\src\\main\\resources\\songs.txt");

    }

    @Bean
    public Player player() throws IOException {
        return new MusicPlayer(songsCreater());
    }

}
