package com.concur.workshop;


import com.concur.workshop.servlet.AddMessage;
import com.concur.workshop.servlet.ListMessages;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class JettyServer extends Server {
    JettyServer() {
        super();

        addConnector(createHttpConnector());

        ServletContextHandler servletContextHandler = new ServletContextHandler(this, "/", false, false);
        servletContextHandler.addServlet(ListMessages.class, "/");
        servletContextHandler.addServlet(AddMessage.class, "/messages");
    }

    private NetworkConnector createHttpConnector() {
        HttpConfiguration httpConfig = new HttpConfiguration();

        ServerConnector connector = new ServerConnector(this, new HttpConnectionFactory(httpConfig));
        connector.setPort(8080);
        connector.setIdleTimeout(30000);

        return connector;
    }
}
