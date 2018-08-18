package org.keyboardplaying.trello.archiver;

import org.keyboardplaying.trello.domain.Board;
import org.keyboardplaying.trello.restclient.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Arrays;
import java.util.List;

@ShellComponent
public class ArchiverCommands {

    private TrelloClient client;

    @Autowired
    public ArchiverCommands(TrelloClient client) {
        this.client = client;
    }

    @ShellMethod("Prints the list of available boards")
    public String init(
            @ShellOption("The API Key you use to access") String apiKey,
            @ShellOption("The token to access a user's data") String token
    ) {
        client.setApiKey(apiKey).setToken(token);
        return "API key and token set!";
    }

    @ShellMethod("Prints the list of available boards")
    public List<?> boards() {
        return client.getBoards();
    }
}
