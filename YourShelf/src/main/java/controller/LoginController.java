package controller;


import dao.DAO;
import dao.UserDAO;
import model.User;
import spark.*;
import controller.LoginController;


public class LoginController {
    private static final UserDAO userDAO = new UserDAO();

    public static Route getLoginPage = (Request req, Response resp) -> {
        resp.redirect("/login.html");
        return null;
    };

    

    public static Route authenticate = (Request req, Response resp) -> {
        String email = req.queryParams("email");
        String password = req.queryParams("senha");

        User user = userDAO.authenticate(email, DAO.toMD5(password));


        if( user != null ) {
            req.session().attribute("user", user);
            return HomePageController.getHomePage.handle(req, resp);
        }

        return null;
    };
}
