package ru.lsp.media_piayer.media_player_bad;

public class VideoUnsupportedException extends Exception {
    @Override
    public String toString() {
        return "VideoUnsupported";
    }
}
