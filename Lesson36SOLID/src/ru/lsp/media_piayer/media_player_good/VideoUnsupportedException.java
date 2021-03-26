package ru.lsp.media_piayer.media_player_good;

public class VideoUnsupportedException extends Exception {
    @Override
    public String toString() {
        return "VideoUnsupported";
    }
}
