package com.noxilon.irc.objects;

public class Message {
    private String message;
    private String username;

    public Message(String message, String username) {
        this.message = message;
        this.username = username;
    }

    public String getContent() {
        return message;
    }

    public String getUser() {
        return username;
    }

    public void setContent(String content) {
        this.message = content;
    }

    public void setUser(String user) {
        this.username = user;
    }
}
