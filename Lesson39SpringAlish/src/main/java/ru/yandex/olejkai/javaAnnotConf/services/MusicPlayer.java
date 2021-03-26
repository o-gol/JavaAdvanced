package ru.yandex.olejkai.javaAnnotConf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ru.yandex.olejkai.javaAnnotConf.enums.TypesEnum;
import ru.yandex.olejkai.javaAnnotConf.objects.abstractClasses.AbstractMusic;
import ru.yandex.olejkai.javaAnnotConf.objects.abstractClasses.AbstractSong;
import ru.yandex.olejkai.javaAnnotConf.objects.objectClasses.ClassicAbstractMusic;
import ru.yandex.olejkai.javaAnnotConf.objects.objectClasses.RackAbstractMusic;
import ru.yandex.olejkai.javaAnnotConf.objects.objectClasses.RapAbstractMusic;
import ru.yandex.olejkai.javaXmlConf.objects.ClassicMusic;
import ru.yandex.olejkai.javaXmlConf.objects.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MusicPlayer implements Player {
    private List<AbstractSong> abstractSongList = new ArrayList<AbstractSong>();
    private List<AbstractMusic> abstractMusicList = new ArrayList<AbstractMusic>();
    @Value("56")
    private int volume;


    public MusicPlayer(AbstractMusic... abstractMusics) {
        for (AbstractMusic abstractMusic :
                abstractMusics) {
            abstractMusicList.add(abstractMusic);
        }
    }


    public MusicPlayer(List<AbstractMusic> abstractMusicList, int i) {
        this.abstractMusicList = abstractMusicList;
    }


    public MusicPlayer(AbstractSong... abstractSongs) {
        for (AbstractSong abstractSong :
                abstractSongs) {
            abstractSongList.add(abstractSong);
        }
        songsSort(abstractSongList);
    }

    public MusicPlayer(List<AbstractSong> abstractSongList) {
        this.abstractSongList = abstractSongList;
        songsSort(abstractSongList);
    }

    private void songsSort(List<AbstractSong> abstractSongList) {
        ClassicAbstractMusic classicAbstractMusic = new ClassicAbstractMusic();
        RackAbstractMusic rackAbstractMusic = new RackAbstractMusic();
        RapAbstractMusic rapAbstractMusic = new RapAbstractMusic();
        for (AbstractSong song :
                abstractSongList) {
            switch (song.getType()) {
                case CLASSIC:
                    classicAbstractMusic.setSong(song);
                    break;
                case RACK:
                    rackAbstractMusic.setSong(song);
                    break;
                case RAP:
                    rapAbstractMusic.setSong(song);
                    break;
            }
        }
        abstractMusicList.add(classicAbstractMusic);
        abstractMusicList.add(rackAbstractMusic);
        abstractMusicList.add(rapAbstractMusic);
    }

    public MusicPlayer() {
    }


    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public List<AbstractSong> getAbstractSongList() {
        return abstractSongList;
    }

    public void setAbstractSongList(List<AbstractSong> abstractSongList) {
        this.abstractSongList = abstractSongList;
    }

    public List<AbstractMusic> getAbstractMusicList() {
        return abstractMusicList;
    }

    public void setAbstractMusicList(List<AbstractMusic> abstractMusicList) throws InterruptedException {
        this.abstractMusicList = abstractMusicList;
        Thread.sleep(2000);
    }

    public void playRandom(){
        System.out.println(abstractMusicList.get(new Random().nextInt(abstractMusicList.size()))
                .getSongs());
    }

    @Override
    public void play() {
        /*if (abstractMusic != null)
//            System.out.printf("Play name- %s, type- %s, volume-%s \n", abstractMusic.getName(), abstractMusic.getType(), volume);
            System.out.println(this);
        else if(!abstractMusicList.isEmpty()){
            for (AbstractMusic abstractMusic:
                 abstractMusicList) {
                System.out.println(this);
            }
        }*/
        System.out.println(this);
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Classic\n2-Rack\n3-Rap");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                playSongsByType(TypesEnum.CLASSIC);
                break;
            case 2:
                playSongsByType(TypesEnum.RACK);
                break;
            case 3:
                playSongsByType(TypesEnum.RAP);
                break;
        }

    }

    private void playSongsByType(TypesEnum typesEnum) {
        for (AbstractMusic music :
                abstractMusicList) {
            if (music.getType() == typesEnum)
                for (AbstractSong song :
                        music.getSongs()) {
                    System.out.printf("Playing %s song %s\n", song.getType(), song.getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        }


    }

    /*private void playSongsByType(TypesEnum typesEnum) {
        for (AbstractMusic music :
                abstractMusicList) {
            for (AbstractSong song :
                    music.getSongs()) {
                if (song.getType() == typesEnum) {
                    System.out.printf("Playing %s song %s\n", song.getType(), song.getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
    }
*/

    @Override
    public String toString() {
        return "MusicPlayer{" +
                "abstractMusicList=" + abstractMusicList +
                ", abstractSongList=" + abstractSongList +
                ", volume=" + volume +
                '}';
    }
}
