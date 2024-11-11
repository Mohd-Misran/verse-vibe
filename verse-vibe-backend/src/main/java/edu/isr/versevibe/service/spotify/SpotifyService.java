package edu.isr.versevibe.service.spotify;

import edu.isr.versevibe.dto.SpotifyResponse;

public interface SpotifyService {
    SpotifyResponse searchTrack(String trackName, String albumName);
}
