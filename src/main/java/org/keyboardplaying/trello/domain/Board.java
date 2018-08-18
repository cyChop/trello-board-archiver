package org.keyboardplaying.trello.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Board initialized from https://developers.trello.com/reference#board-object
 *
 * @author Cyrille Chopelet
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Board {
    private String id;
    private String name;
    @Deprecated
    private String desc;
    private String descData;
    private boolean closed;
    private String idOrganization;
    private boolean pinned;
    private String url;
    private String shortUrl;
    // private Object prefs;
    // private Object labelNames;
    private boolean starred;
    // private Object limits;
    // private List<Object> memberships;

    public String toString() {
        return String.format("[%s] %s", id, name);
    }
}
