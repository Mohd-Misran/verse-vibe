package edu.isr.versevibe.service.spotify.impl;

import edu.isr.versevibe.dto.SpotifyResponse;
import edu.isr.versevibe.service.spotify.SpotifyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.http.MediaType;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@Service
public class DefaultSpotifyService implements SpotifyService {
    @Value("${spotify.client-id}")
    private String clientId;

    @Value("${spotify.client-secret}")
    private String clientSecret;

    @Value("${spotify.api-base-url}")
    private String apiBaseUrl;

    private final RestTemplate restTemplate;

    public DefaultSpotifyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SpotifyResponse searchTrack(String trackName, String artistName) {
        String accessToken = getAccessToken();
        String query = String.format("track:\"%s\" artist:\"%s\"", trackName, artistName);

        String url = UriComponentsBuilder.fromHttpUrl(apiBaseUrl + "/search")
                .queryParam("q", query)
                .queryParam("type", "track")
                .queryParam("market", "US")
                .queryParam("limit", 5)
                .queryParam("offset", 0)
                .toUriString();
        System.out.println("URL: " + url);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<SpotifyResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                SpotifyResponse.class
        );
        return response.getBody();
    }

    private String getAccessToken() {
        String tokenUrl = "https://accounts.spotify.com/api/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Encode client ID and client secret in Base64 using Java's Base64 class
        String auth = clientId + ":" + clientSecret;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        headers.set("Authorization", "Basic " + encodedAuth);

        // Body parameters for grant type
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                tokenUrl,
                HttpMethod.POST,
                request,
                Map.class
        );

        Map<String, Object> responseBody = response.getBody();
        if (responseBody != null) {
            System.out.println("Generated Access Token: " + responseBody.get("access_token"));
            return (String) responseBody.get("access_token");
        } else {
            throw new RuntimeException("Failed to retrieve access token from Spotify");
        }
    }
}
