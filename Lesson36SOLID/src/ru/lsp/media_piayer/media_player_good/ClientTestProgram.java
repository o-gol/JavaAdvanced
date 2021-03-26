package ru.lsp.media_piayer.media_player_good;

import java.util.ArrayList;
import java.util.List;

public class ClientTestProgram {

    public static void main(String[] args) throws VideoUnsupportedException {
        List<VideoMedeaPlayer> mediaPlayers = new ArrayList<>();
        mediaPlayers.add(new VLCMediaPlayer());
        mediaPlayers.add(new TorMediaPlayer());
        videoStart(mediaPlayers);
        System.out.println("-----------------------------------------------------");
//        mediaPlayers.add(new WinampMediaPlayer());
//        videoStart(mediaPlayers);

    }
    static void videoStart(List<VideoMedeaPlayer> mediaPlayers) throws VideoUnsupportedException {
        for (VideoMedeaPlayer player :
                mediaPlayers) {
            player.playVideo();
        }
    }
}
