package controller;
import dao.DAO;
import dao.UserDAO;
import model.User;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.UUID;

public class RegisterController {
    private static final UserDAO userDAO = new UserDAO();

    public static Route getRegisterPage = (Request req, Response resp) -> {
        resp.redirect("/register.html");
        return null;
    };

    public static Route registerUser = (Request req, Response resp) -> {
        String first_name = req.queryParams("first_name");
        String last_name = req.queryParams("last_name");
        String email = req.queryParams("email");
        String password = req.queryParams("password");

        
        String id = UUID.randomUUID().toString();
        User user;

        user = new User(id, email, DAO.toMD5(password), first_name, last_name);
        userDAO.insert(user);

        resp.redirect("/login.html");
        return null;
    };

}
