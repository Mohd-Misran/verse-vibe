package edu.isr.versevibe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;


@Setter
public class SpotifyResponse {

    Tracks tracks;

    @Override
    public String toString() {
        return "SpotifyResponse{" +
                "tracks=" + tracks +
                '}';
    }

    @JsonProperty("tracks")
    public Tracks getTracks() {
        return this.tracks;
    }

}
