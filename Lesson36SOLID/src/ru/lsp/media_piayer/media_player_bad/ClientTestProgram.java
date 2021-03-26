package ru.lsp.media_piayer.media_player_bad;

import java.util.ArrayList;
import java.util.List;

public class ClientTestProgram {

    public static void main(String[] args) throws VideoUnsupportedException {
        List<MediaPlayer> mediaPlayers = new ArrayList<>();
        mediaPlayers.add(new VLCMediaPlayer());
        mediaPlayers.add(new TorMediaPlayer());
        videoStart(mediaPlayers);
        System.out.println("-----------------------------------------------------");
        mediaPlayers.add(new WinampMediaPlayer());
        videoStart(mediaPlayers);

    }
    static void videoStart(List<MediaPlayer> mediaPlayers) throws VideoUnsupportedException {
        for (MediaPlayer player :
                mediaPlayers) {
            player.playVideo();
        }
    }
}
