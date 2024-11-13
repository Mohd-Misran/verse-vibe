package edu.isr.versevibe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.ArrayList;

@Setter
public class Item {
    @JsonProperty("album")
    public Album getAlbum() {
        return this.album;
    }

    Album album;

    @Override
    public String toString() {
        return "Item{" +
                "album=" + album +
                ", artists=" + artists +
                ", disc_number=" + disc_number +
                ", duration_ms=" + duration_ms +
                ", explicit=" + explicit +
                ", external_ids=" + external_ids +
                ", external_urls=" + external_urls +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", is_local=" + is_local +
                ", is_playable=" + is_playable +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", preview_url=" + preview_url +
                ", track_number=" + track_number +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }

    @JsonProperty("artists")
    public ArrayList<Artist> getArtists() {
        return this.artists;
    }

    ArrayList<Artist> artists;

    @JsonProperty("disc_number")
    public int getDisc_number() {
        return this.disc_number;
    }

    int disc_number;

    @JsonProperty("duration_ms")
    public int getDuration_ms() {
        return this.duration_ms;
    }

    int duration_ms;

    @JsonProperty("explicit")
    public boolean getExplicit() {
        return this.explicit;
    }

    boolean explicit;

    @JsonProperty("external_ids")
    public ExternalIds getExternal_ids() {
        return this.external_ids;
    }

    ExternalIds external_ids;

    @JsonProperty("external_urls")
    public ExternalUrls getExternal_urls() {
        return this.external_urls;
    }

    ExternalUrls external_urls;

    @JsonProperty("href")
    public String getHref() {
        return this.href;
    }

    String href;

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    String id;

    @JsonProperty("is_local")
    public boolean getIs_local() {
        return this.is_local;
    }

    boolean is_local;

    @JsonProperty("is_playable")
    public boolean getIs_playable() {
        return this.is_playable;
    }

    boolean is_playable;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    String name;

    @JsonProperty("popularity")
    public int getPopularity() {
        return this.popularity;
    }

    int popularity;

    @JsonProperty("preview_url")
    public Object getPreview_url() {
        return this.preview_url;
    }

    Object preview_url;

    @JsonProperty("track_number")
    public int getTrack_number() {
        return this.track_number;
    }

    int track_number;

    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    String type;

    @JsonProperty("uri")
    public String getUri() {
        return this.uri;
    }

    String uri;
}
