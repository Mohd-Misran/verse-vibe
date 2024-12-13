package edu.isr.versevibe.dto.spotify;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SpotifySearchTracksResponse {
    private String href;
    private Integer limit;
    private String next;
    private Integer offset;
    private String previous;
    private Integer total;
    private List<SpotifyTrack> items;
}
