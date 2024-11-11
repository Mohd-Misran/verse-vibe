package edu.isr.versevibe;

import edu.isr.versevibe.utils.CSVUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.isr.versevibe.service.spotify.SpotifyService;
import edu.isr.versevibe.dto.SpotifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
/*
@SpringBootApplication
public class VerseVibeApplication {

    public static void main(String[] args) {
        CSVUtils.readCSV("src/main/resources/documents/song_lyrics.csv");
        SpringApplication.run(VerseVibeApplication.class, args);

    }
}
 */

@SpringBootApplication
public class VerseVibeApplication implements CommandLineRunner {

    @Autowired
    private SpotifyService spotifyService;

    public static void main(String[] args) {
        SpringApplication.run(VerseVibeApplication.class, args);
        System.out.println("Hello");
    }

    @Override
    public void run(String... args) throws Exception {
        // Call the searchTrack method and print the output for testing
        SpotifyResponse response = spotifyService.searchTrack("Blinding Lights", "Weeknd");
        System.out.println(response.toString()); // or format it as needed
    }
}
