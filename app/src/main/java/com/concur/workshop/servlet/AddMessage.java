package com.concur.workshop.servlet;

import com.concur.workshop.Message;
import com.concur.workshop.MessageStore;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddMessage extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MessageStore store = new MessageStore();

        final String submit = request.getParameter("send_message");
        final String nickname = request.getParameter("nickname");
        final String text = request.getParameter("text");

        if (submit.equals("Send message")) {
            store.addMessage(new Message(nickname, text));
        }

        response.sendRedirect("/");
    }
}
