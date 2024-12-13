package edu.isr.versevibe.dto.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SpotifyAlbum {
    private String id;
    private String name;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("album_type")
    private String albumType;

    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;

    private List<Image> images;
}
