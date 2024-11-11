package edu.isr.versevibe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Setter
public class ExternalUrls{
    @Override
    public String toString() {
        return "ExternalUrls{" +
                "spotify='" + spotify + '\'' +
                '}';
    }

    @JsonProperty("spotify")
    public String getSpotify() { 
		 return this.spotify; }

    String spotify;
}
