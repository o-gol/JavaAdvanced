package ru.yandex.olejkai.javaAnnotConf.objects.abstractClasses;

import ru.yandex.olejkai.javaAnnotConf.enums.TypesEnum;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMusic {
    private TypesEnum type;
    private List<AbstractSong> songs=new ArrayList<>();

    public AbstractMusic(List<AbstractSong> songs) {
        this.songs = songs;
    }

    public AbstractMusic(AbstractSong... songs){
        for (AbstractSong song :
                songs) {
            this.songs.add(song);
        }
    }

    public AbstractMusic() {
    }

    public TypesEnum getType() {
        return type;
    }

    public void setType(TypesEnum type) {
        this.type = type;
    }

    public List<AbstractSong> getSongs() {
        return songs;
    }

    public void setSongs(List<AbstractSong> songs) {
        this.songs = songs;
    }

    public void setSong(AbstractSong song) {
        this.songs.add(song);
    }

    @Override
    public String toString() {
        return "AbstractMusic{" +
                "type='" + type + '\'' +
                ", name='" + songs + '\'' +
                '}';
    }
}
