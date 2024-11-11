package edu.isr.versevibe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.ArrayList;

@Setter
public class Album{
    @JsonProperty("album_type") 
    public String getAlbum_type() { 
		 return this.album_type; }

    String album_type;
    @JsonProperty("artists") 
    public ArrayList<Artist> getArtists() { 
		 return this.artists; }

    ArrayList<Artist> artists;
    @JsonProperty("external_urls") 
    public ExternalUrls getExternal_urls() { 
		 return this.external_urls; }

    ExternalUrls external_urls;
    @JsonProperty("href") 
    public String getHref() { 
		 return this.href; }

    String href;
    @JsonProperty("id") 
    public String getId() { 
		 return this.id; }

    String id;
    @JsonProperty("images") 
    public ArrayList<Image> getImages() { 
		 return this.images; }

    ArrayList<Image> images;
    @JsonProperty("is_playable") 
    public boolean getIs_playable() { 
		 return this.is_playable; }

    boolean is_playable;
    @JsonProperty("name")
    public String getName() { 
		 return this.name; }

    String name;
    @JsonProperty("release_date") 
    public String getRelease_date() { 
		 return this.release_date; }

    String release_date;
    @JsonProperty("release_date_precision") 
    public String getRelease_date_precision() { 
		 return this.release_date_precision; }

    String release_date_precision;
    @JsonProperty("total_tracks") 
    public int getTotal_tracks() { 
		 return this.total_tracks; }

    int total_tracks;
    @JsonProperty("type") 
    public String getType() { 
		 return this.type; }

    String type;
    @JsonProperty("uri") 
    public String getUri() { 
		 return this.uri; }

    @Override
    public String toString() {
        return "Album{" +
                "album_type='" + album_type + '\'' +
                ", artists=" + artists +
                ", external_urls=" + external_urls +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", images=" + images +
                ", is_playable=" + is_playable +
                ", name='" + name + '\'' +
                ", release_date='" + release_date + '\'' +
                ", release_date_precision='" + release_date_precision + '\'' +
                ", total_tracks=" + total_tracks +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }

    String uri;
}
