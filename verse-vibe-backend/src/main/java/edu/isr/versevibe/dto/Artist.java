package edu.isr.versevibe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Setter
public class Artist{
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
    @JsonProperty("name") 
    public String getName() { 
		 return this.name; }

    String name;

    @Override
    public String toString() {
        return "Artist{" +
                "external_urls=" + external_urls +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }

    @JsonProperty("type")
    public String getType() { 
		 return this.type; }

    String type;
    @JsonProperty("uri") 
    public String getUri() { 
		 return this.uri; }

    String uri;
}
