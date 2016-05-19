package com.concur.workshop;

//import javax.annotation.Nonnull;

public class Message {
    private String text;
    private String nickname;

    public Message(final String nickname, final String message) {
        if (nickname == null || message == null) {
            throw new IllegalArgumentException("Argument can't be null or empty");
        }
        this.nickname = nickname;
        this.text = message;
    }

    public final String getText() {
        return text;
    }

    public final String getNickname() {
        return nickname;
    }
}
