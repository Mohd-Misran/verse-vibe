package edu.isr.versevibe.mapper;

import edu.isr.versevibe.dto.Song;
import edu.isr.versevibe.dto.result.Album;
import edu.isr.versevibe.dto.result.Artist;
import edu.isr.versevibe.dto.result.SongResult;
import edu.isr.versevibe.dto.spotify.SpotifyArtist;
import edu.isr.versevibe.dto.spotify.SpotifySearchResponse;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SongMapper {
    public static SongResult toSongResult(final Song song, final SpotifySearchResponse spotifySearchResponse) {
        final SongResult songResult = new SongResult();
        songResult.setElasticSearchId(song.getElasticsearchId());
        songResult.setName(spotifySearchResponse.getTracks().getItems().get(0).getName());
        populateAlbumData(songResult, spotifySearchResponse);
        songResult.setExplicit(spotifySearchResponse.getTracks().getItems().get(0).getExplicit());
        populateArtistData(songResult, song, spotifySearchResponse);
        populateDuration(songResult, spotifySearchResponse.getTracks().getItems().get(0).getDurationInMilliseconds());
        songResult.setDocId(song.getDocId());
        songResult.setSpotifyId(spotifySearchResponse.getTracks().getItems().get(0).getId());
        return songResult;
    }

    private static void populateDuration(final SongResult songResult, final Integer durationInMilliseconds) {
        final Duration duration = Duration.ofMillis(durationInMilliseconds);
        int minutes = duration.toMinutesPart();
        int seconds = duration.toSecondsPart();
        final String durationString = String.format("%02d:%02d", minutes, seconds);
        songResult.setDuration(durationString);
    }

    private static void populateArtistData(final SongResult songResult, final Song song,
                                           final SpotifySearchResponse spotifySearchResponse) {
        final List<Artist> artists = new ArrayList<>();
        for (SpotifyArtist spotifyArtist : spotifySearchResponse.getTracks().getItems().get(0).getArtists()) {
            final Artist artist = new Artist();
            artist.setName(spotifyArtist.getName());
            artist.setSpotifyId(spotifyArtist.getId());
            artist.setSpotifyUrl(spotifyArtist.getExternalUrls().getSpotify());
            artists.add(artist);
            songResult.setArtists(artists);
        }
    }

    private static void populateAlbumData(final SongResult songResult,
                                          final SpotifySearchResponse spotifySearchResponse) {
        final Album album = new Album();
        album.setName(spotifySearchResponse.getTracks().getItems().get(0).getAlbum().getName());
        album.setImages(spotifySearchResponse.getTracks().getItems().get(0).getAlbum().getImages());
        songResult.setAlbum(album);
    }
}
