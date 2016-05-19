package com.concur.workshop.servlet;


import com.concur.workshop.Message;
import com.concur.workshop.MessageStore;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ListMessages extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>Messages:</h1>");

        MessageStore store = new MessageStore();

        int index = 0;

        for (Message message : store.getMessages()) {
            out.println("<p>");
            out.println(String.format("#%d:", ++index));
            out.println(message.getNickname());
            out.println(" - ");
            out.println(message.getText());
            out.println("</p>");
        }

        out.println("<form method=\"post\" action=\"messages\">");
        out.println("<p>Nickname: <input type=\"text\" name=\"nickname\" /></p>");
        out.println("<p><textarea name=\"text\"></textarea><p>");
        out.println("<p><input type=\"submit\" name=\"send_message\" value=\"Send message\" /></p>");
        out.println("</form>");
    }
}
