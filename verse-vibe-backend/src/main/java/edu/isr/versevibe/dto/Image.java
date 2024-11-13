package edu.isr.versevibe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Setter
public class Image {
    @JsonProperty("height")
    public int getHeight() {
        return this.height;
    }

    int height;

    @Override
    public String toString() {
        return "Image{" +
                "height=" + height +
                ", url='" + url + '\'' +
                ", width=" + width +
                '}';
    }

    @JsonProperty("url")
    public String getUrl() {
        return this.url;
    }

    String url;

    @JsonProperty("width")
    public int getWidth() {
        return this.width;
    }

    int width;
}
