package edu.isr.versevibe.dto.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpotifyArtist {
    private String id;
    private String name;

    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
}
