package ru.yandex.olejkai.javaXmlConf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.yandex.olejkai.javaXmlConf.objects.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class MusicPlayer implements Player {
    @Autowired
//    @Qualifier("musicConfig")
    List<Music> musicList = new ArrayList<>();
    @Autowired
    @Qualifier("classicMusic")
    private Music music;
    @Value("43")
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //    @Autowired
    public MusicPlayer(Music... musics) {
        for (Music music :
                musics) {
            musicList.add(music);
        }
    }

//    @Autowired
    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public MusicPlayer() {
    }

    //    @Autowired
    public MusicPlayer(
//            @Qualifier("classicMusic")
            Music music) {
        this.music = music;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    @Override
    public void play() {
        /*if (music != null)
//            System.out.printf("Play name- %s, type- %s, volume-%s \n", music.getName(), music.getType(), volume);
            System.out.println(this);
        else if(!musicList.isEmpty()){
            for (AbstractMusic music:
                 musicList) {
                System.out.println(this);
            }
        }*/
        System.out.println(this);
        Scanner scanner=new Scanner(System.in);
        System.out.println("1-Classic\n2-Rack");
        int choose=scanner.nextInt();
        switch (choose){
            case 1:
                for (Music music :
                        musicList) {
                    if (music.getType() == "classic") {
                        System.out.printf("Playing %s song %s\n", music.getType(), music.getName());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
                if (music!=null&&music.getType()=="classic"){
                    System.out.printf("Playing %s song %s\n", music.getType(), music.getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                for (Music music :
                        musicList) {
                    if (music.getType() == "rack") {
                        System.out.printf("Playing %s song %s\n", music.getType(), music.getName());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (music!=null&&music.getType()=="rack"){
                    System.out.printf("Playing %s song %s\n", music.getType(), music.getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }

    }

    @Override
    public String toString() {
        return "MusicPlayer{" +
                "musicList=" + musicList +
                ", music=" + music +
                ", volume=" + volume +
                '}';
    }
}
