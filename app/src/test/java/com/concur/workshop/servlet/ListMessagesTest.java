package com.concur.workshop.servlet;

import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * @author AndrejS
 */
public class ListMessagesTest {

    @Test
    public void testListMessageTest() throws IOException {

        ListMessages listMessages = new ListMessages();
        HttpServletRequest request = PowerMockito.mock(HttpServletRequest.class);
        HttpServletResponse response = PowerMockito.mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));

        listMessages.doGet(request, response);

        Mockito.verify(response, times(1)).setContentType("text/html");
    }

}
