package controller;
import spark.*;

public class IndexController  {
    public static Route getIndexPage = (Request req, Response resp) -> {
        resp.redirect("/index.html");
        return null;
    };
}
