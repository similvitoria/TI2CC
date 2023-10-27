package controller;

import dao.ListDAO;
import model.Lists;
import model.User;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.StringWriter;
import java.util.Properties;
import java.util.UUID;

public class HomePageController {
    private static final ListDAO listDAO = new ListDAO();


    public static Route getHomePage = (Request req, Response resp) -> {
        //user da sessão
        User user = req.session().attribute("user");

        // Configurar o ambiente do Velocity
        VelocityEngine velocityEngine = new VelocityEngine();
        Properties properties = new Properties();
        properties.setProperty("input.encoding", "UTF-8");
        properties.setProperty("output.encoding", "UTF-8");
        velocityEngine.init(properties);
        VelocityContext context = new VelocityContext();

        Template template = velocityEngine.getTemplate("src/main/resources/public/homePage.vm");


        java.util.List<Lists> list = ListDAO.getAllLists(user.getId());
        context.put("list", list);
        context.put("user", user);

        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        String htmlContent = writer.toString();

        resp.type("text/html; charset=UTF-8");
        return htmlContent;
    };

    public static Route registerList = (Request req, Response resp) -> {
        //user da sessão
        User user = req.session().attribute("user");

        String list_name = req.queryParams("name");

        String id = UUID.randomUUID().toString();

        Lists list;

        list = new Lists(id, list_name, user.getId());
        listDAO.insert(list);

        System.out.println("inseriu" + list.toString());

        return HomePageController.getHomePage.handle(req, resp);
    };
}
