package edu.isr.versevibe.mapper;

import edu.isr.versevibe.dto.Song;
import edu.isr.versevibe.dto.result.SongResult;
import edu.isr.versevibe.dto.spotify.SpotifySearchResponse;

public class SongMapper {
    public static SongResult toSongResult(Song song, SpotifySearchResponse spotifySearchResponse) {
        SongResult songResult = new SongResult();
        return songResult;
    }
}
