package com.concur.workshop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageStore {
    private static List<Message> messages = null;

    public MessageStore() {
        if (messages == null) {
            messages = Collections.synchronizedList(new ArrayList<Message>());
        }
    }

    public List<Message> getMessages() {
        return Collections.unmodifiableList(messages);
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
}
