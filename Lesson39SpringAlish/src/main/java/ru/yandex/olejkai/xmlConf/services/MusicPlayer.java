package ru.yandex.olejkai.xmlConf.services;

import ru.yandex.olejkai.xmlConf.objects.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer implements Player {
    List<Music> musicList = new ArrayList<>();
    private Music music;
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public MusicPlayer(Music... musics) {
        for (Music music :
                musics) {
            musicList.add(music);
        }
    }

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public MusicPlayer() {
    }

    public MusicPlayer(Music music) {
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
