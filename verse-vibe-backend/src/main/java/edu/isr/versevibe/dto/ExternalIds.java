package edu.isr.versevibe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Setter
public class ExternalIds{
    @JsonProperty("isrc")
    public String getIsrc() { 
		 return this.isrc; }

    @Override
    public String toString() {
        return "ExternalIds{" +
                "isrc='" + isrc + '\'' +
                '}';
    }

    String isrc;
}
