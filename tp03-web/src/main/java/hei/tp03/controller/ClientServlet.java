package hei.tp03.controller;

import hei.tp03.config.AppConfig;
import hei.tp03.entity.Client;
import hei.tp03.service.ClientService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ClientServlet extends HttpServlet {

    private ClientService clientService;
    private ConfigurableApplicationContext context;

    public void init(){
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        clientService = context.getBean(ClientService.class);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        List<Client> listeClient = clientService.findAll();
        for (Client c : listeClient)
            out.write(c.getNom());
    }

    public void destroy(){
        context.close();
    }
}
