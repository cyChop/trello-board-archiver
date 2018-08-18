package org.keyboardplaying.trello.restclient;

import org.keyboardplaying.trello.domain.Board;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrelloClient {

    private static final String TRAILING_SLASH = "/";

    private final String apiBaseUrl;

    private String apiKey;
    private String token;

    public TrelloClient(@Value("${trello.api.root:https://api.trello.com/}") String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl.endsWith("/") ? apiBaseUrl : apiBaseUrl + TRAILING_SLASH;
    }

    public TrelloClient setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public TrelloClient setToken(String token) {
        this.token = token;
        return this;
    }

    public List<Board> getBoards() {
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.asList(restTemplate
                .getForObject(String.format("%s1/members/me/boards?key=%s&token=%s", apiBaseUrl, apiKey, token),
                        Board[].class));
    }
}
