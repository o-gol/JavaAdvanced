package ru.yandex.olejkai.javaAnnotConf.services;

import ru.yandex.olejkai.javaAnnotConf.enums.TypesEnum;
import ru.yandex.olejkai.javaAnnotConf.objects.abstractClasses.AbstractSong;
import ru.yandex.olejkai.javaAnnotConf.objects.objectClasses.Song;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SongListFactory {
    public static List<AbstractSong> songsCreator(String path) throws IOException {
        List<AbstractSong> songs = new ArrayList<>();
        File file=new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String string = reader.readLine();
        while (string != null) {
            switch (reader.readLine()) {
                case "classic":
                    songs.add(new Song(string, TypesEnum.CLASSIC));
                    break;
                case "rack":
                    songs.add(new Song(string, TypesEnum.RACK));
                    break;
                case "rap":
                    songs.add(new Song(string, TypesEnum.RAP));
                    break;
            }
            string = reader.readLine();
        }
        return songs;
    }
}
