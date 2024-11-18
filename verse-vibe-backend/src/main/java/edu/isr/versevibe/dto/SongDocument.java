package edu.isr.versevibe.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class SongDocument {
    private String title;
    private String tag;
    private List<String> artist;
    private String year;
    private String features;
    private String lyrics;
    private String id;
    private String language;
    private Date generatedAt;

    @Override
    public String toString() {
        return "SongDocument{" +
                "title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", artist='" + artist + '\'' +
                ", year='" + year + '\'' +
                ", features='" + features + '\'' +
                ", lyrics='" + lyrics + '\'' +
                ", id='" + id + '\'' +
                ", language='" + language + '\'' +
                ", generatedAt=" + generatedAt +
                '}';
    }
}