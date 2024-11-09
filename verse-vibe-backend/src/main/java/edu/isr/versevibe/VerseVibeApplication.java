package edu.isr.versevibe;

import edu.isr.versevibe.utils.CSVUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VerseVibeApplication {

    public static void main(String[] args) {
        CSVUtils.readCSV("src/main/resources/documents/song_lyrics.csv");
        SpringApplication.run(VerseVibeApplication.class, args);
    }

}
